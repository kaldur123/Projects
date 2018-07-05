package project.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.dto.ArticleDto;
import project.dto.CommentDto;
import project.entity.Article;
import project.entity.Comment;
import project.mapper.ArticleMapper;
import project.mapper.CommentMapper;
import project.service.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class RestApiController {

    @Autowired private CloudinaryService cloudinaryService;

    @Autowired private ImageService imageService;

    @Autowired private DinoService dinoService;

    @Autowired private WriterService writerService;

    @Autowired private CommentService commentService;

    @Autowired private ArticleService articleService;

    @PostMapping(value = "/load-image/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadAvatar(@RequestParam("file")MultipartFile file, @PathVariable("id") Long id) {
        String url;
        if (writerService.findById(id).getRole().getRole().equals("ADMIN")) {
            url = cloudinaryService.uploadFile(file, "admin_" + id);
        }
        else {
            url = cloudinaryService.uploadFile(file, "user_" + id);
        }
        writerService.updateImage(url, id);
        System.out.println(writerService.findById(id).getRole());
        System.out.println(file.getOriginalFilename());
        return new ResponseEntity<String>(url, HttpStatus.CREATED);
    }

    @GetMapping("/articles/{id}")
    public List<CommentDto> showComments(@PathVariable("id")Long id) {
        return commentService.findAllByArticleId(id).stream().map(p -> CommentMapper.convertToDto(p)).collect(Collectors.toList());
    }

    @PostMapping("/articles/{id}/save-comment")
    public ResponseEntity<Void> saveComment(Principal principal, @RequestParam("text") String text, @PathVariable("id")Long id) {
        Comment comment = new Comment();
        comment.setText(text);
        comment.setArticle(articleService.findById(id));
        comment.setWriter(writerService.findByEmail(principal.getName()));
        commentService.saveComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping("/test")
//    public Map<String, List<String>> kindName() {
//        Map<String, List<String>> map = new HashMap<>();
//        List<String> kinds = dinoService.findDinoKind();
//        for (int i = 0; i < kinds.size(); i++) {
//            map.put(kinds.get(i), dinoService.findDinoByKind(kinds.get(i)));
//        }
//        return map;
//    }
}

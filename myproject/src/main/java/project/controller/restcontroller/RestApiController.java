package project.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.dto.ArticleDto;
import project.dto.CommentDto;
import project.dto.ImageDto;
import project.entity.Article;
import project.entity.Comment;
import project.entity.Image;
import project.mapper.ArticleMapper;
import project.mapper.CommentMapper;
import project.mapper.ImageMapper;
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
        comment.setArticle(articleService.getById(id));
        comment.setWriter(writerService.findByEmail(principal.getName()));
        commentService.saveComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/articles/dino/{id}")
    public List<ImageDto> getImages(@PathVariable("id") Long id) {
        return imageService.findAllByDinoId(id).stream().map(p -> ImageMapper.convertToDto(p)).collect(Collectors.toList());
    }

    @PostMapping(value = "/articles/dino/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<Void> saveImage(@RequestParam("file")MultipartFile file, @PathVariable("id") Long id) {
        String url = cloudinaryService.uploadFile(file, dinoService.findById(id).getName());
        Image image = new Image();
        image.setImage(url);
        image.setDino(dinoService.findById(id));
        imageService.saveImage(image);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
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

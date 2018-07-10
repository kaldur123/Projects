package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dto.ArticleDto;
import project.dto.WriterDto;
import project.dto.WriterDtoReg;
import project.dto.filters.ArticleFilter;
import project.entity.Article;
import project.entity.Enums.UserRole;
import project.entity.Writer;
import project.exception.PageNotFoundException;
import project.mapper.ImageMapper;
import project.mapper.WriterMapper;
import project.service.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"countries", "nums"})
public class HomeController {

    @Autowired private WriterService writerService;

    @Autowired private DinoService dinoService;

    @Autowired private ArticleService articleService;

    @Autowired private ImageService imageService;

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String showErrorDenied() {
        return "403";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("userDtoReg", new WriterDtoReg());
        List<Integer> num = new ArrayList<>();
        for (int i = 18; i <= 100; i++) {
            num.add(i);
        }
        List<String> country = new ArrayList<>();
        country.add("Ukraine");
        country.add("Russia");
        country.add("England");
        country.add("Poland");
        country.add("Hungary");
        country.add("USA");
        country.add("Italy");
        country.add("France");
        country.add("Australia");
        country.add("China");
        country.add("Japan");
        country.add("India");
        country.add("Greece");
        model.addAttribute("countries", country);
        model.addAttribute("nums", num);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("userDtoReg")WriterDtoReg writerDtoReg, BindingResult br) {
        if (br.hasErrors()) {
            return "register";
        }
        Writer writer = WriterMapper.convertToWriterReg(writerDtoReg);
        writer.setImageUrl("http://placehold.it/140x100&text=" + writer.getFullName());
        writer.setRole(UserRole.ROLE_USER);
        writerService.saveWriter(writer);
        return "redirect:/user";
    }

    @GetMapping("/articles")
    public String showArticles(Model model, @PageableDefault Pageable pageable) {
//        model.addAttribute("articles", articleService.findAll());
        model.addAttribute("filter", new ArticleFilter());
        Page<Article> page = articleService.findAllByPage(pageable);
        int currentPage = page.getNumber();
        if (currentPage > page.getTotalPages()) {
            throw new PageNotFoundException("Page not found");
        }
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("size", pageable.getPageSize());
        model.addAttribute("count", Arrays.asList(5, 10, 15, 20));
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pages", page);
        model.addAttribute("articles", page.getContent());
        model.addAttribute("title", new ArticleFilter().getSearchTitle());
        model.addAttribute("dinoName", new ArticleFilter().getSearchDinoName());
        return "articles";
    }

    @GetMapping("/articles/search")
    public String showArticlesByFilter(@ModelAttribute("filter") ArticleFilter articleFilter, Model model, Pageable pageable) {
        Page<Article> page = articleService.findAllByFilter(articleFilter, pageable);
        int currentPage = page.getNumber();
        if (currentPage > page.getTotalPages() - 1) {
            throw new PageNotFoundException("Page not found");
        }
        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("size", pageable.getPageSize());
        model.addAttribute("count", Arrays.asList(5, 10, 15, 20));
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pages", page);
        model.addAttribute("articles", page.getContent());
        model.addAttribute("title", articleFilter.getSearchTitle());
        model.addAttribute("dinoName", articleFilter.getSearchDinoName());
        return "articles";
    }

    @GetMapping("/articles/{id}")
    public String showArticle(@PathVariable("id")Long id, Model model, Principal principal) {
        model.addAttribute("article", articleService.findById(id));
        if (principal != null) {
            model.addAttribute("writerName", principal.getName());
            model.addAttribute("testId", writerService.findByEmail(principal.getName()).getId());
        }
        return "article";
    }

    @PostMapping("/articles/{id}/delete")
    public String deleteArticle(@ModelAttribute("article") Article article) {
        articleService.deleteArticle(articleService.findById(article.getId()));
        return "redirect:/articles";
    }

    @GetMapping("/articles/dino/{id}")
    public String showDinoImages(@PathVariable("id") Long id, Model model, Principal principal) {
        model.addAttribute("dinoId", dinoService.findDinoById(id).getId());
        if (principal != null) {
            model.addAttribute("writerName", principal.getName());
        }
        return "dino-images";
    }

//    @GetMapping("/test")
//    public String test(Model model) {
//        model.addAttribute("articleDto", new ArticleDto());
//        model.addAttribute("kinds", dinoService.findDinoKind());
//        List<List<String>> names = new ArrayList<>();
//        for (int i = 0; i < dinoService.findDinoKind().size(); i++) {
//            names.add(dinoService.findDinoByKind(dinoService.findDinoKind().get(i)));
//        }
//        model.addAttribute("names", names);
//        return "test";
//    }
}
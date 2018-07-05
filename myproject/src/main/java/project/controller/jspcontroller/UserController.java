package project.controller.jspcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dto.ArticleDto;
import project.dto.WriterDto;
import project.entity.Article;
import project.entity.Dino;
import project.entity.Writer;
import project.mapper.ArticleMapper;
import project.mapper.WriterMapper;
import project.service.ArticleService;
import project.service.DinoService;
import project.service.WriterService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes({"kinds", "names", "countries", "nums"})
public class UserController {

    @Autowired private WriterService writerService;

    @Autowired private ArticleService articleService;

    @Autowired private DinoService dinoService;

    @GetMapping("")
    public String showUserPage(Principal principal, Model model) {

        System.out.println("Username: " + principal.getName());
        model.addAttribute("userProfile", writerService.findByEmail(principal.getName()));
        return "user";
    }

    @GetMapping("/info")
    public String userInfo(Principal principal, Model model) {
        model.addAttribute("user", writerService.findByEmail(principal.getName()));
        return "user-info";
    }

    @GetMapping("/edit")
    public String editUserInfo(Model model, Principal principal) {
        model.addAttribute("user", WriterMapper.convertToDto(writerService.findByEmail(principal.getName())));
        model.addAttribute("userId", writerService.findByEmail(principal.getName()).getId());
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            num.add(i);
        }
        List<String> countries = new ArrayList<>();
        countries.add("Ukraine");
        countries.add("Russia");
        countries.add("England");
        countries.add("Poland");
        countries.add("Hungary");
        countries.add("USA");
        countries.add("Italy");
        countries.add("France");
        countries.add("Australia");
        countries.add("China");
        countries.add("Japan");
        countries.add("India");
        countries.add("Greece");
        model.addAttribute("countries", countries);
        model.addAttribute("nums", num);
        return "user-edit";
    }

    @PostMapping("/edit")
    public String editUser(@Valid @ModelAttribute("user") WriterDto writerDto, Principal principal, BindingResult br) {
        System.out.println(writerDto);
        if (br.hasErrors()) {
            return "user-edit";
        }
        Writer writer = WriterMapper.convertToWriter(writerDto);
        writerService.updateWriter(writer.getFullName(), writer.getAge(), writer.getCountry(), writerService.findByEmail(principal.getName()).getId());
        return "redirect:/user/info";
    }

    @GetMapping("/add-article")
    public String addArticle(Model model) {
        model.addAttribute("articleDto", new ArticleDto());
        model.addAttribute("kinds", dinoService.findDinoKind());
        List<List<String>> names = new ArrayList<>();
        for (int i = 0; i < dinoService.findDinoKind().size(); i++) {
            names.add(dinoService.findDinoByKind(dinoService.findDinoKind().get(i)));
        }
        model.addAttribute("names", names);
        return "add-article";
    }

    @PostMapping("/add-article")
    public String saveArticle(@RequestParam("content") String description,@Valid @ModelAttribute("articleDto") ArticleDto articleDto, Principal principal, BindingResult br) {
        if (br.hasErrors()) {
            return "add-article";
        }
        Article article = ArticleMapper.convertToArticle(articleDto);
        article.setDescription(description);
        article.setWriter(writerService.findByEmail(principal.getName()));
        article.setDino(dinoService.findDinoByName(articleDto.getDinoName()));
        articleService.saveArticle(article);
        return "redirect:/user";
    }

    @GetMapping("/my-articles")
    public String showMyArticles(Principal principal, Model model) {
        model.addAttribute("articles", articleService.findAllByUserId(writerService.findByEmail(principal.getName()).getId()));
        return "user-articles";
    }

    @GetMapping("/my-articles/{id}")
    public String editArticle(Model model, @PathVariable("id") Long id) {
        model.addAttribute("articleDto", ArticleMapper.convertToDto(articleService.findById(id)));
        model.addAttribute("articleId", id);
        model.addAttribute("content", articleService.findById(id).getDescription());
        return "article-edit";
    }

    @PostMapping("/my-articles/{id}")
    public String saveEdit(@Valid @ModelAttribute("articleDto") ArticleDto articleDto, @RequestParam("id") Long id, BindingResult br) {
        if (br.hasErrors()) {
            return "article-edit";
        }
        Article article = ArticleMapper.convertToArticle(articleDto);
        articleService.updateArticle(article.getTitle(), id);
        return "redirect:/user";
    }
}

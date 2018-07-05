package ua.logos.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.logos.spring.entity.Enum.Degree;
import ua.logos.spring.entity.Enum.Gender;
import ua.logos.spring.entity.Enum.Rank;
import ua.logos.spring.entity.User;
import ua.logos.spring.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/add")
    public String showAddUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Add user form");
        List<String> langs = new ArrayList<>();
        langs.add("Java");
        langs.add("JS");
        langs.add("C++");
        langs.add("C");
        langs.add("Python");
        langs.add("C++");
        langs.add("PHP");

        List<String> countries = new ArrayList<>();
        countries.add("Ukraine");
        countries.add("Russia");
        countries.add("USA");
        countries.add("Poland");
        countries.add("Germany");
        countries.add("France");
        countries.add("China");

        List<String> networks = new ArrayList<>();
        networks.add("Facebook");
        networks.add("Vkontakte");
        networks.add("Twitter");
        networks.add("Odnoklasniki");

        List<String> os = new ArrayList<>();
        os.add("Windows");
        os.add("Linux");
        os.add("MAC OS");

        List<String> technologies = new ArrayList<>();
        technologies.add("MYSQL");
        technologies.add("JDBC");
        technologies.add("HIBERNATE");
        technologies.add("HTML");
        technologies.add("CSS");
        technologies.add("SPRING");
        technologies.add("MAVEN");


        model.addAttribute("progList", langs);
        model.addAttribute("countryList", countries);
        model.addAttribute("gender", Gender.values());
        model.addAttribute("degrees", Degree.values());
        model.addAttribute("networks", networks);
        model.addAttribute("ranks", Rank.values());
        model.addAttribute("os", os);
        model.addAttribute("technologies", technologies);

        return "user/add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "user/users";
    }

    @GetMapping("/info/{userId}")
    public String showUserById(@PathVariable("userId") int id, Model model) {
        model.addAttribute("userInfo", userService.showUserById(id));

        return "user/user-info";
    }


}

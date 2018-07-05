package project.controller.jspcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dto.DinoDto;
import project.dto.WriterDto;
import project.entity.Dino;
import project.entity.Enums.UserRole;
import project.entity.Writer;
import project.mapper.DinoMapper;
import project.mapper.WriterMapper;
import project.service.DinoService;
import project.service.WriterService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"countries", "nums"})
public class AdminController {

    @Autowired private WriterService writerService;

    @Autowired private DinoService dinoService;

    @GetMapping("")
    public String showAdminPage(Principal principal, Model model) {
        System.out.println("Username: " + principal.getName());
        model.addAttribute("adminProfile", writerService.findByEmail(principal.getName()));
        return "admin";
    }

    @GetMapping("/info")
    public String adminInfo(Principal principal, Model model) {
        model.addAttribute("user", writerService.findByEmail(principal.getName()));
        return "user-info";
    }

    @GetMapping("/edit")
    public String editUser(Principal principal, Model model) {
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
        return "admin-edit";
    }

    @PostMapping("/edit")
    public String updateUser(@Valid @ModelAttribute("user") WriterDto writerDto, Principal principal, BindingResult br) {
        if (br.hasErrors()) {
            return "admin-edit";
        }
        Writer writer = WriterMapper.convertToWriter(writerDto);
        writerService.updateWriter(writer.getFullName(), writer.getAge(), writer.getCountry(), writerService.findByEmail(principal.getName()).getId());
        return "redirect:/admin/info";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", writerService.findUsersByRole(UserRole.ROLE_USER));
        return "users";
    }

    @GetMapping("/users/info/{id}")
    public String showUserInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", writerService.findById(id));
        model.addAttribute("userId", id);
        return "user-info";
    }

    @PostMapping("/users/info/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long id) {
        writerService.deleteWriter(writerService.getById(id));
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{userId}")
    public String showUserEdit(@PathVariable("userId")Long id, Model model) {
        model.addAttribute("user", WriterMapper.convertToDto(writerService.findById(id)));
        model.addAttribute("userId", id);
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

    @PostMapping("/users/edit/{userId}")
    public String editUser(@Valid @ModelAttribute("user") WriterDto writerDto, @PathVariable("userId")Long id, BindingResult br) {
        if (br.hasErrors()) {
            return "user-edit";
        }
        Writer writer = WriterMapper.convertToWriter(writerDto);
        writerService.updateWriter(writerDto.getFullName(), writerDto.getAge(), writerDto.getCountry(), id);
        return "redirect:/admin/users";
    }

    @GetMapping("/add-dino")
    public String addDino(Model model) {
        model.addAttribute("dinoDto", new DinoDto());
        return "add-dino";
    }

    @PostMapping("/add-dino")
    public String saveDino(@Valid @ModelAttribute("dinoDto")DinoDto dinoDto, BindingResult br) {
        if (br.hasErrors()) {
            return "add-dino";
        }
        Dino dino = DinoMapper.convertToDino(dinoDto);
        dinoService.saveDino(dino);
        return "redirect:/";
    }

}

package project.controller.jspcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dto.DinoDto;
import project.dto.WriterDto;
import project.dto.filters.UserFilter;
import project.entity.Dino;
import project.entity.Enums.UserRole;
import project.entity.Writer;
import project.exception.PageNotFoundException;
import project.mapper.DinoMapper;
import project.mapper.WriterMapper;
import project.service.DinoService;
import project.service.WriterService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
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
        for (int i = 18; i <= 100; i++) {
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
    public String showAllUsers(Model model, @PageableDefault Pageable pageable) {
//        model.addAttribute("users", writerService.findUsersByRole(UserRole.ROLE_USER));
        model.addAttribute("filter", new UserFilter());
        Page<Writer> page = writerService.findWritersByPage(pageable);
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
        model.addAttribute("users", page.getContent());
        model.addAttribute("fullName", new UserFilter().getSearchFullName());
        model.addAttribute("age", new UserFilter().getSearchAge());
        model.addAttribute("email", new UserFilter().getSearchEmail());
        model.addAttribute("country", new UserFilter().getSearchCountry());

        return "users";
    }

    @GetMapping("/users/search")
    public String showAllUsersByFilter(@ModelAttribute("filter") UserFilter userFilter, Model model, Pageable pageable) {
//        model.addAttribute("users", writerService.findUsersByRole(UserRole.ROLE_USER));
        Page<Writer> page = writerService.findWritersByPage(userFilter, pageable);
        int currentPage = page.getNumber();
        if (currentPage > page.getTotalPages() - 1) {
            throw new PageNotFoundException("Page not found");
        }

        int begin = Math.max(1, currentPage - 2);
        int end = Math.min(begin + 2, page.getNumber());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);

        model.addAttribute("size", userFilter.getSize());
        model.addAttribute("count", Arrays.asList(5, 10, 15, 20));
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pages", page);
        model.addAttribute("users", page.getContent());
        model.addAttribute("fullName", userFilter.getSearchFullName());
        model.addAttribute("age", userFilter.getSearchAge());
        model.addAttribute("email", userFilter.getSearchEmail());
        model.addAttribute("country", userFilter.getSearchCountry());
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
        for (int i = 18; i <= 100; i++) {
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

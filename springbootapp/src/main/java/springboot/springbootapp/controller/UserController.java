package springboot.springbootapp.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.springbootapp.dto.UserDto;
import springboot.springbootapp.dto.filter.MyFilter;
import springboot.springbootapp.dto.filter.SimpleFilter;
import springboot.springbootapp.entity.Image;
import springboot.springbootapp.entity.User;
import springboot.springbootapp.mapper.UserMapper;
import springboot.springbootapp.service.ImageService;
import springboot.springbootapp.service.UserService;
import springboot.springbootapp.service.utils.CustomFileUtils;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Controller
@SessionAttributes("count")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired private ImageService imageService;

    @GetMapping("/add/user")
    public String showUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "add-user";
    }

    @PostMapping("/add/user")
    public String addUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult br) {
        if (br.hasErrors()) {
            return "add-user";
        }
        User user = UserMapper.convert(userDto);
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String showUsers(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("myFilter", new MyFilter());
        Page<User> page = userService.findUsersByPage(pageable);
        int currentPage = page.getNumber();

        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());

        model.addAttribute("size", pageable.getPageSize());
        model.addAttribute("count", Arrays.asList(5, 10, 15, 20, 50));
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pages", page);
        model.addAttribute("userList", page.getContent());
        model.addAttribute("firstName", new MyFilter().getSearchFirstName());
        model.addAttribute("lastName", new MyFilter().getSearchLastName());
        model.addAttribute("email", new MyFilter().getSearchEmail());
        model.addAttribute("login", new MyFilter().getSearchLogin());
        model.addAttribute("minsalary", new MyFilter().getSearchMinSalary());
        model.addAttribute("maxsalary", new MyFilter().getSearchMaxSalary());

        return "userlist";
    }

    @GetMapping("/users/search")
    public String showUsersByFilter(@ModelAttribute("myFilter")MyFilter filter, Model model, Pageable pageable) {
        Page<User> page = userService.findUsersByPage(filter, pageable);
        int currentPage = page.getNumber();

        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());

        model.addAttribute("size", filter.getSize());
        model.addAttribute("count", Arrays.asList(5, 10, 15, 20, 50));
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pages", page);
        model.addAttribute("userList", page.getContent());
        model.addAttribute("firstName", filter.getSearchFirstName());
        model.addAttribute("lastName", filter.getSearchLastName());
        model.addAttribute("email", filter.getSearchEmail());
        model.addAttribute("login", filter.getSearchLogin());
        model.addAttribute("minsalary", filter.getSearchMinSalary());
        model.addAttribute("maxsalary", filter.getSearchMaxSalary());


        return "userlist";
    }

    @PostMapping("/users/{id}")
    public String saveImage(@ModelAttribute Image image, @RequestParam("file") MultipartFile file, @PathVariable("id") int id) throws IOException {
        imageService.updateImage(file.getOriginalFilename(), file.getBytes(), id);
        CustomFileUtils.createImg("user_" + id, file);
        return "redirect:/users";
    }

    @GetMapping("/users/info/{id}")
    public String userInfo(@PathVariable("id") int id, Model model) throws IOException {
        model.addAttribute("userInfo", userService.findUserById(id));
        byte[] arr = new byte[(int) new File("D:\\default.png").length()];
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\default.png"));
        fileInputStream.read(arr);
        String encodeFile = new String(Base64.encodeBase64(arr));
        if(imageService.findByUserId(id).getImageName().equals("default")) {
            model.addAttribute("imgSrc", encodeFile);
        }
        else{
            model.addAttribute("imgSrc", CustomFileUtils.getImg("user_" + id, imageService.findByUserId(id).getImageName()));
        }

        return "user-info";
    }

}

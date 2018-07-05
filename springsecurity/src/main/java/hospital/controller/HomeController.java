package hospital.controller;

import hospital.dto.DoctorsAppointmentDto;
import hospital.dto.UserDto;
import hospital.entity.DoctorsAppointment;
import hospital.entity.Pet;
import hospital.entity.User;
import hospital.entity.enumer.UserRole;
import hospital.mapper.AppointmentMapper;
import hospital.mapper.UserMapper;
import hospital.service.DoctorsAppointmentService;
import hospital.service.PetService;
import hospital.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class HomeController {

    @Autowired private UserService userService;

    @Autowired private PetService petService;

    @Autowired private DoctorsAppointmentService doctorsAppointmentService;

    @GetMapping("/")
    public String showHome(Model model, @PageableDefault Pageable pageable) {
        Page<User> page = userService.findByRole(UserRole.ROLE_DOCTOR, pageable);
        int currentPage = page.getNumber();

        int begin = Math.max(1, currentPage - 5);
        int end = Math.min(begin + 5, page.getNumber());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pages", page);
        model.addAttribute("userList", page.getContent());

        return "home";
    }

    @GetMapping("/info/{id}")
    public String info(Model model, @PathVariable("id") Long id) {
        model.addAttribute("doc", userService.findUserById(id));
        model.addAttribute("imgSrc", new String(Base64.encodeBase64(userService.findUserById(id).getImage())));
        return "info";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client")
    public String showClientPage(Principal principal, Model model) {
        model.addAttribute("client",  userService.findByLogin(principal.getName()));
        return "client";
    }

    @PostMapping("/client")
    public String changeImage(@ModelAttribute("client")User user, @RequestParam("file")MultipartFile file) throws IOException {
        userService.updateImage(file.getBytes(), user.getId());

        return "redirect:/client";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client/edit")
    public String editClient(Principal principal, Model model) {
        model.addAttribute("client", userService.findByLogin(principal.getName()));
        return "edit";
    }

    @PostMapping("/client/edit")
    public String edit(@ModelAttribute("client") User user, @RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("phoneNumber") int phoneNumber, @RequestParam("date") LocalDate date, @RequestParam("city") String city, @RequestParam("street") String street) {
        userService.updateClient(login, password, phoneNumber, date, city + ", " + street, user.getId());
        return "redirect:/client";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roles", Arrays.asList(UserRole.ROLE_CLIENT, UserRole.ROLE_DOCTOR));
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("userDto")UserDto userDto) throws IOException {
        User user = UserMapper.convertToUser(userDto);
        userService.saveUser(user);

        return "redirect:/";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String login() {
        return "login-form";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client/addpet")
    public String addPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "addpet";
    }

    @PostMapping("/client/addpet")
    public String savePet(@ModelAttribute("pet")Pet pet, Principal principal) throws IOException {
        petService.savePet(pet, userService.findByLogin(principal.getName()).getId());
        return "redirect:/client";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client/editpet")
    public String showPet(Principal principal, Model model) {
        model.addAttribute("pets", petService.findPetsByUserId(userService.findByLogin(principal.getName()).getId()));

        return "editpet";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client/editpet/{id}")
    public String editPet(@PathVariable("id")Long id, Model model) {
        model.addAttribute("pet", petService.findPetById(id));

        return "editpetinf";
    }

    @PostMapping("/client/editpet/{id}")
    public String changePet(@ModelAttribute("pet")Pet pet, @RequestParam("type") String type, @RequestParam("age") int age, @RequestParam("name") String name, @RequestParam("color") String color, @RequestParam("weight") int weight) {
        petService.updatePet(type, age, name, color, weight, pet.getId());

        return "redirect:/client/editpet";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client/editpet/image/{id}")
    public String petImg(Model model, @PathVariable("id")Long id) {
        model.addAttribute("petImg", petService.findPetById(id));
        return "petimg";
    }

    @PostMapping("/client/editpet/image/{id}")
    public String editImg(@RequestParam("img")MultipartFile file, @ModelAttribute("petImg")Pet pet) throws IOException {
        petService.updateImg(file.getBytes(), pet.getId());
        return "redirect:/client";
    }

    @PostMapping("/client/deletepet")
    public String deletePet(@ModelAttribute("pet")Pet pet) {
        petService.deletePet(pet);

        return "redirect:/client";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/client/visit/{id}")
    public String createVisit(Model model, @PathVariable("id")Long id) {
        model.addAttribute("appoint", new DoctorsAppointmentDto());
        return "visit";
    }

    @PostMapping("/client/visit/{id}")
    public String addVisit(@ModelAttribute("appoint") DoctorsAppointmentDto doctorsAppointmentDto, @PathVariable("id")Long id) {
        DoctorsAppointment doctorsAppointment = AppointmentMapper.convert(doctorsAppointmentDto);
        doctorsAppointmentService.saveAppointment(doctorsAppointment, id);
        return "redirect:/client";
    }

    @GetMapping("/client/allvisits")
    public String showVisits(Model model, Principal principal) {
        model.addAttribute("visits", );
    }

}

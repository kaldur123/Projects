package ua.logos.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.logos.spring.entity.Animal;
import ua.logos.spring.entity.Enum.Gender;
import ua.logos.spring.service.AnimalService;

@Controller
@RequestMapping("/animal")
@SessionAttributes("editAnimalModel")
public class AnimalController {

    @Autowired private AnimalService animalService;

    @GetMapping("/add")
    public String showAddAnimalForm() {
        return "animal/add";
    }

    @PostMapping("/add")
    public String addAnimal(
            @RequestParam("name") String name,
            @RequestParam("kind") String kind,
            @RequestParam("gender") Gender gender) {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setKind(kind);
        animal.setGender(gender);

        animalService.saveAnimal(animal);

        return "redirect:/";

    }


//    @GetMapping("/animals")
//    public String getAnimals(Model model) {
//        model.addAttribute("animalsList", animalService.findAllAnimals());
//
//        return "animal/list";
//    }


    @GetMapping("/info/{animalId}")
    public String showInfo(@PathVariable("animalId") int animalId, Model model) {
        model.addAttribute("animalInfo", animalService.findAnimalById(animalId));
        return "animal/info";
    }

    @GetMapping("/delete/{animalId}")
    public String deleteAnimal(@PathVariable("animalId") int animalId) {
        animalService.deleteAnimalById(animalId);
        return "redirect:/animal/list";
    }


    @GetMapping("/name")
    public String showInfoByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("animalInfo", animalService.findAnimalByName(name));
        return "animal/info";
    }

    @GetMapping("/list")
    public String showAnimals(Model model) {
        model.addAttribute("animalList", animalService.findAllAnimals());
        return "animal/list";
    }
    @GetMapping("/add-spring")
    public String addAnimalSpring(Model model) {
        model.addAttribute("animalModel", new Animal());
        return "animal/add-spring";
    }

    @PostMapping("/add-spring")
    public String saveAnimalSpring(@ModelAttribute("animalModel") Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/";
    }

    @GetMapping("/edit/{animalId}")
    public String showEditAnimal(@PathVariable("animalId") int animalId, Model model) {
        model.addAttribute("editAnimalModel", animalService.findAnimalById(animalId));
        return "animal/edit";
    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute("editAnimalModel") Animal animal, SessionStatus sessionStatus) {

        animalService.saveAnimal(animal);
        sessionStatus.isComplete();
        return "redirect:/";
    }
}

package springboot.springbootapp.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.springbootapp.entity.LoadFile;
import springboot.springbootapp.service.LoadFileInterface;

import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class LoadFileController {

    @Autowired private LoadFileInterface loadFileInterface;


    @GetMapping("/db")
    public String showLoadToDb(Model model) {
        model.addAttribute("loadFileModel", new LoadFile());
        return "load-file";
    }


//    @PostMapping("/db")
//    public String saveFile(@ModelAttribute LoadFile file, @RequestParam("loadFile")MultipartFile multipartFile) throws IOException {
//
//        System.out.println("File Name: " + multipartFile.getOriginalFilename());
//
//        file.setFileName(multipartFile.getOriginalFilename());
//
//
//        file.setFileData(multipartFile.getBytes());
//
//        loadFileInterface.save(file);
//
//        return "redirect:/";
//    }

    @PostMapping("/db")
    public String saveFile(@ModelAttribute LoadFile file) throws IOException {

        file.setFileName(file.getFile().getOriginalFilename());
        file.setFileData(file.getFile().getBytes());

        return "redirect:/";
    }


    @GetMapping("/show-db")
    public String showFromDb(Model model) {

        LoadFile file = loadFileInterface.findOneById(1);

        String encodeFile = new String(Base64.encodeBase64(file.getFileData()));

        model.addAttribute("imgSrc", encodeFile);



        return "show";
    }
}

package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.models.Image;
import project.repository.CourseRepository;
import project.repository.UserRepository;
import project.service.ImageServiceInter;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ImageController {



    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ImageServiceInter imageServiceInter;




    @PostMapping("/upload/{idCourse}")
    public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long idCourse) throws IOException {
        return imageServiceInter.uploadImage(file,idCourse);
    }

    @GetMapping("/get/{idCourse}")
    public ResponseEntity<Image>getImageByidCourse(@PathVariable Long idCourse)
    {
        return imageServiceInter.getImage(idCourse);


    }



    @PutMapping("/update/{idCourse}")

    public ResponseEntity<String>updateImage(@RequestParam("imageFile") MultipartFile file,  @PathVariable Long idCourse) throws IOException {

        return imageServiceInter.updateImage(file,idCourse);
    }



    @DeleteMapping("/delete/{idCourse}")
    public ResponseEntity<String>deleteImage(@PathVariable Long idCourse)
    {
        return imageServiceInter.deleteImage(idCourse);
    }


}

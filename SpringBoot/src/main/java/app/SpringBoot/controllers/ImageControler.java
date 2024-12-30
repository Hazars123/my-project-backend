package app.SpringBoot.controllers;

import app.SpringBoot.entities.Image;
import app.SpringBoot.services.ImageServiceIInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ImageControler {

    @Autowired
    ImageServiceIInter imageServiceIInter;

    @PostMapping("/upload/{idCourse}")
    public ResponseEntity<String> uploadImage(@RequestParam("imageFile")MultipartFile file, @PathVariable Long idCourse) throws IOException {
        return imageServiceIInter.uploadImage(file,idCourse);
    }


    @GetMapping("/get/{idCourse}")
    public ResponseEntity<Image> getImageByUserId(@PathVariable Long idCourse)
    {
        return imageServiceIInter.getImage(idCourse);

    }


@PutMapping("update/{idCourse}")
    public ResponseEntity<String> updateImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long idCourse) throws IOException {
    return imageServiceIInter.updateImage(file, idCourse);
}


@DeleteMapping("/delete/{idCourse}")
    public ResponseEntity<String> deleteImage(@PathVariable Long idCourse)
{
    return imageServiceIInter.deleteImage(idCourse);
}


}

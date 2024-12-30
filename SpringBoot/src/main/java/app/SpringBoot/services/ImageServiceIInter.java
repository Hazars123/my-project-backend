package app.SpringBoot.services;

import app.SpringBoot.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageServiceIInter {


    ResponseEntity<String> uploadImage(MultipartFile file, Long idCourse) throws IOException;
    ResponseEntity<Image> getImage(Long idCourse);

    ResponseEntity<String> updateImage(MultipartFile file, Long idCourse) throws IOException;

    ResponseEntity<String> deleteImage(Long idCourse);
}

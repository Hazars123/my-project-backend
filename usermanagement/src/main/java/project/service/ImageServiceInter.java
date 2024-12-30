package project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import project.models.Image;

import java.io.IOException;

public interface ImageServiceInter {


    ResponseEntity<String> uploadImage(MultipartFile file, Long idCourse) throws IOException;

    ResponseEntity<Image> getImage(Long idCourse);

    ResponseEntity<String> updateImage(MultipartFile file, Long idCourse) throws IOException;

    ResponseEntity<String> deleteImage(Long idCourse);
}

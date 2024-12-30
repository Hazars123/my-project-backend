package app.SpringBoot.services;

import app.SpringBoot.entities.Course;
import app.SpringBoot.entities.Image;
import app.SpringBoot.repository.CourseRepository;
import app.SpringBoot.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageServiceImpl implements ImageServiceIInter {

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public ResponseEntity<String> uploadImage(MultipartFile file, Long idCourse) throws IOException {
        Optional<Course> courseOptional=courseRepository.findById(idCourse);
        if(courseOptional.isPresent())
        {
            if(courseOptional.get().getCourseImage()!=null){
                return ResponseEntity.badRequest().body("course already has an image");

            }
            Image img =new Image();
            img.setName(file.getOriginalFilename());
            img.setPicByte(compressBytes(file.getBytes()) );
            img.setCourse(courseOptional.get());
            imageRepository.save(img);
            return ResponseEntity.ok("Image( "+img.getName()+" ) added to course "+ courseOptional.get().getTitle());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<Image> getImage(Long idCourse) {

        Optional<Image> retrivedImage = imageRepository.findByCourseId(idCourse);
        if(retrivedImage.isPresent())
        {
            Image img =retrivedImage.get();
            img.setPicByte(decompressBytes(img.getPicByte()));
            return ResponseEntity.ok(img);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<String> updateImage(MultipartFile file, Long idCourse) throws IOException {
        Optional<Course> optionalCourse=courseRepository.findById(idCourse);
        if(optionalCourse.isPresent())
        {
            Course course =optionalCourse.get();
            Image image=course.getCourseImage();
            image.setName(file.getOriginalFilename());
            image.setPicByte(file.getBytes());
            imageRepository.save(image);
            return ResponseEntity.ok("Updated");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteImage(Long idCourse) {

        Optional<Course> optionalCourse=courseRepository.findById(idCourse);
        if(optionalCourse.isPresent())
        {
            Course course=optionalCourse.get();
            Image img = course.getCourseImage();
            if(img!=null){
                imageRepository.delete(img);
                return ResponseEntity.ok("Image deleted of user"+idCourse);
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }


    }


    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }








}

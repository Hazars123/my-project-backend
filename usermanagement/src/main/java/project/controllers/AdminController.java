package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.models.Course;
import project.repository.CourseRepository;
import project.service.CourseServiceInter;
import project.service.ImageServiceInter;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseServiceInter courseServiceInter;
    @PostMapping("/addCr")
    public Course addCourse(@RequestBody Course course ){
        return courseServiceInter.addCourse(course);
    }
    @DeleteMapping("/deleteCr/{id}")
    public void deleteCourse(@PathVariable Long id )
    {
        courseServiceInter.delete(id);
    }


    @PostMapping("/addCrs")
    public List<Course> courses(@RequestBody List<Course> courses)
    {
        return courseServiceInter.addCourses(courses);

    }
    //update
    @PutMapping("updateCr/{id}")
    public Course updateCourse(@RequestBody Course course,@PathVariable Long id )
    {
        return courseServiceInter.updateCourse(course,id);

    }





    @GetMapping("/getAllCr")
    public List<Course> getAllCourses()
    {
        return courseServiceInter.getAllCourses();


    }


    @GetMapping("/getCrById/{id}")
    public Course getCourseById(@PathVariable Long id)
    {
        return courseServiceInter.getCourseById(id);

    }

}

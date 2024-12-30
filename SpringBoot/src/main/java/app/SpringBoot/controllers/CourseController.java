package app.SpringBoot.controllers;

import app.SpringBoot.entities.Course;
import app.SpringBoot.entities.UserEntity;
import app.SpringBoot.services.CourseServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {
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

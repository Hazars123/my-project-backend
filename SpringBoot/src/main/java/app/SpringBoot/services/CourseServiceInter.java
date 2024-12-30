package app.SpringBoot.services;

import app.SpringBoot.entities.Course;

import java.util.List;

public interface CourseServiceInter {
    Course addCourse(Course course);

    void delete(Long id);

    List<Course> addCourses(List<Course> courses);

    Course updateCourse(Course course, Long id);

    List<Course> getAllCourses();

    Course getCourseById(Long id);
}

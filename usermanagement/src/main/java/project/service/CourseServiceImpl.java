package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.Course;
import project.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInter{
    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);

    }

    @Override
    public List<Course> addCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Course cr= courseRepository.findById(id).get();

        course.setTitle(cr.getTitle() );
        course.setPrice(cr.getPrice() );
        return courseRepository.save(cr);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();    }


}


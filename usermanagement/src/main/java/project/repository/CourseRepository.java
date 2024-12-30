package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {}
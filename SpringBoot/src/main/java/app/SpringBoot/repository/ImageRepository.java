package app.SpringBoot.repository;

import app.SpringBoot.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    Optional<Image> findByCourseId(Long idCourse);
}

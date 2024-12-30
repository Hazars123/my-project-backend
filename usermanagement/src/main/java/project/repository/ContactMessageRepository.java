package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.ContactMessage;

import javax.persistence.Entity;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}

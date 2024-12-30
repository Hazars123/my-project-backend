package app.SpringBoot.repository;

import app.SpringBoot.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Long> {
    boolean existsByUsername(String username);


    @Query(value = "select * from users u where u.username like :cle%",nativeQuery = true )
    List<UserEntity> getUsersSTWUN(@Param("cle") String un);

    UserEntity findByUsername(String un);

//
}

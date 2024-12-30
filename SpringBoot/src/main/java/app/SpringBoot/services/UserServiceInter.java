package app.SpringBoot.services;

import app.SpringBoot.entities.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInter {
    UserEntity userAdd(UserEntity user);
    void delete(Long id);

    List<UserEntity> usersT(List<UserEntity> users);

    String addUserWTUN(UserEntity userEntity);

    UserEntity updateUserPut(UserEntity userEntity, Long id);


    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    List<UserEntity> getUsersSTWUN( String un );

    UserEntity getUserByUsername(String un);

    ResponseEntity<UserEntity> login(String username, String password);

    UserEntity userAddC(UserEntity user);

    ResponseEntity<UserEntity> loginC(String username, String password);
}

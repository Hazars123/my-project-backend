package app.SpringBoot.controllers;

import app.SpringBoot.entities.UserEntity;
import app.SpringBoot.services.UserServiceInter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {


    @Autowired
    UserServiceInter userServiceInter;



    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user ){
        return userServiceInter.userAdd(user);
    }




    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id )
    {
        userServiceInter.delete(id);
    }


    @PostMapping("/addUsers")
    public List<UserEntity> users(@RequestBody List<UserEntity> users)
    {
        return userServiceInter.usersT(users);

    }




    //test with usernmane
    @PostMapping("/addUserWTUN")
    public String addUserWTUN(@RequestBody UserEntity userEntity)
    {
        return userServiceInter.addUserWTUN(userEntity);


    }


//Crypt
    @PostMapping("/addC")
    public UserEntity addUserC(@RequestBody UserEntity user ){
        return userServiceInter.userAddC(user);
    }








    //update
    @PutMapping("updateUserP/{id}")
    public UserEntity updateUserPut(@RequestBody UserEntity userEntity,@PathVariable Long id )
    {
        return userServiceInter.updateUserPut(userEntity,id);

    }





    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers()
    {
        return userServiceInter.getAllUsers();


    }


    @GetMapping("/getUserById/{id}")
    public UserEntity getUserById(@PathVariable Long id)
    {
        return userServiceInter.getUserById(id);

    }


    @GetMapping("/getUserByUsername/{un}")
    public UserEntity getUserByUsername(@PathVariable String un)
    {
        return userServiceInter.getUserByUsername(un);
    }





//get users start with username
    @GetMapping("/getUsersSTWUN/{un}")

    public List<UserEntity> getUsersSTWUN(@PathVariable String un)
    {
        return userServiceInter.getUsersSTWUN(un);


    }


    @GetMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestParam String username,@RequestParam String password)
    {
        return userServiceInter.login(username,password);
    }


    @GetMapping("/loginC")
    public ResponseEntity<UserEntity> loginC(@RequestParam String username,@RequestParam String password)
    {
        return userServiceInter.loginC(username,password);
    }
}

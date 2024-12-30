package app.SpringBoot.services;

import app.SpringBoot.entities.Role;
import app.SpringBoot.entities.UserEntity;
import app.SpringBoot.repository.RoleRepository;
import app.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInter{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public UserEntity userAdd(UserEntity user) {

        return userRepository.save(user);

    }





    @Override
    public ResponseEntity<UserEntity> login(String username, String password) {
        UserEntity user=userRepository.findByUsername(username);
      //  if(user!=null && user.getPassword()==password )
        if(user!=null && user.getPassword().equals(password))
        {
            return  ResponseEntity.ok(user);
        }else {
            return ResponseEntity.status((HttpStatus.UNAUTHORIZED)).build();
        }



    }

    @Override
    public ResponseEntity<UserEntity> loginC(String username, String password) {
        UserEntity user=userRepository.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

        if(user!=null && passwordEncoder.matches(password,user.getPassword()))
        {
return ResponseEntity.ok(user);

        }else
        {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }



    @Override
    public UserEntity userAddC(UserEntity user) {
        Role role=roleRepository.findById(1L).orElse(null);
        user.getRole().add(role);

        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encryptedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }




    @Override
    public void delete(Long id)
    {
        userRepository.deleteById(id);

    }


    @Override
    public List<UserEntity> usersT(List<UserEntity> us)
    {

    return   userRepository.saveAll(us);

    }



    @Override
    public String addUserWTUN(UserEntity userEntity) {
        String ch="";
        if(userRepository.existsByUsername(userEntity.getUsername()))
        {
            ch="username already exists";
        }else{
            userRepository.save(userEntity);
            ch="user added";
        }

        return ch;
    }

    @Override
    public UserEntity updateUserPut(UserEntity userEntity, Long id) {

        UserEntity user= userRepository.findById(id).get();

        user.setUsername(userEntity.getUsername() );
        return userRepository.save(user);

    }





    @Override
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> users= userRepository.findAll();
        return  users;
        //return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id){

        return userRepository.findById(id).get();
    }

    //USERNAME
    @Override
    public UserEntity getUserByUsername(String un) {
        return userRepository.findByUsername(un);
    }




    @Override
    public List<UserEntity> getUsersSTWUN(String un) {
        return userRepository.getUsersSTWUN(un);
    }




}

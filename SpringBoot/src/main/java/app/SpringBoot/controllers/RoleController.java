package app.SpringBoot.controllers;

import app.SpringBoot.entities.Image;
import app.SpringBoot.entities.Role;
import app.SpringBoot.entities.UserEntity;
import app.SpringBoot.repository.RoleRepository;
import app.SpringBoot.services.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class RoleController {


    @Autowired
    RoleRepository roleRepository;


    @PostMapping("/addRole")
    public Role AddRole ( @RequestBody Role role)
    {
        return roleRepository.save(role);
    }


}

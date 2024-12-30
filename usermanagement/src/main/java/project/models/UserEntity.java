package project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date creationDate;




    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private UserRole userRole;

    @OneToMany(mappedBy = "userEntity")
    private Set<ContactMessage> contactMessages= new HashSet<>();

}

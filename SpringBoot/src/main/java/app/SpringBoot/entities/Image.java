package app.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @Lob
    @Column(name = "picByte",columnDefinition = "LONGBLOB")  //LONGBLOB not LONGLOB
    byte [] picByte;
    @OneToOne
    @JoinTable(name="course_image_assoiation")
    private  Course course;
}

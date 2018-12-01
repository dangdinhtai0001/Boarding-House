package hus.k61a3.demo.home.domains;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "config_home")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConfigHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
}

package cnpm.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import lombok.*;


@Data
@Entity
@Table(name = "customer", schema = "boarding_house")
public class Customer {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "identityNumber")
    private String identityNumber;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "mail")
    private String mail;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "description")
    private String description;
    @Column(name ="isStudent")
    private byte isStudent;
    @Column(name ="declarationOfTemporaryResidence")
    private byte declarationOfTemporaryResidence;
    @Column(name ="company")
    private String company;
    @Column(name ="image")
    private String image;

}

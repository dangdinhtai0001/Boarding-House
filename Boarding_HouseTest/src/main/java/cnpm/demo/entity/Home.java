package cnpm.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;
import  lombok.*;

@Data
@Entity
@Table(name = "home", schema = "boarding_house")
public class Home {
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;


}

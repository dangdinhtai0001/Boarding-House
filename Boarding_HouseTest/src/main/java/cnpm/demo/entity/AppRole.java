package cnpm.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import lombok.*;

@Entity
@Table(name = "app_role", schema = "boarding_house")
@Data
public class AppRole {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
}

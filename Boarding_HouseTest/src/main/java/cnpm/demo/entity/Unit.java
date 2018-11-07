package cnpm.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import lombok.*;

@Data
@Entity
@Table(name = "unit", schema = "boarding_house")
public class Unit {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

}

package cnpm.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import lombok.*;

@Data
@Entity
@Table(name = "service", schema = "boarding_house")
public class Service {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private int status;
    @Column(name = "isDefault")
    private byte isDefault;
    @Column(name = "price")
    private double price;
    @Column(name = "duration")
    private int duration;
    @Column(name = "unitId")
    private int unitId;


}

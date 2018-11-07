package cnpm.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import lombok.*;

@Data
@Entity
@Table(name = "device", schema = "boarding_house")
public class Device {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "roomId")
    private int roomId;
    @Column(name = "unitId")
    private int unitId;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private int amount;
    @Column(name = "price")
    private int price;
    @Column(name = "compensatory")
    private int compensatory;
    @Column(name = "description")
    private String description;
}

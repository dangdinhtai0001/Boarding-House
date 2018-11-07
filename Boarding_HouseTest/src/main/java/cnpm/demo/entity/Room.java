package cnpm.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import lombok.*;

@Data
@Entity
@Table(name = "room", schema = "boarding_house")
public class Room {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "recommend")
    private int recommend;
    @Column(name = "floor")
    private int floor;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;

}

package cnpm.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import lombok.*;

@Data
@Entity
@Table(name = "contract", schema = "boarding_house")
public class Contract {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "customerID")
    private int customerId;
    @Column(name = "roomID")
    private int roomId;
    @Column(name = "serviceID")
    private int serviceId;
    @Column(name = "type")
    private int type;
    @Column(name = "duration")
    private int duration;
    @Column(name = "payCycle")
    private int payCycle;
    @Column(name = "deposit")
    private double deposit;
    @Column(name = "start")
    private Date start;
    @Column(name = "end")
    private Date end;
    @Column(name = "description")
    private double description;

}

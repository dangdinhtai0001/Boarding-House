package cnpm.demo.entity;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "room_rental", schema = "boarding_house")
@IdClass(RoomRentalEntityPK.class)
public class RoomRental {
    @Id
    @Column(name = "customerID")
    private int customerId;
    @Id
    @Column(name = "roomId")
    private int roomId;


}

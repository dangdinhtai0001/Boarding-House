package cnpm.demo.entity;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "service_rental", schema = "boarding_house")
@IdClass(ServiceRentalEntityPK.class)
public class ServiceRental {
    @Id
    @Column(name = "serviceID")
    private int serviceId;
    @Id
    @Column(name = "roomId")
    private int roomId;


}

package cnpm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import lombok.*;

@Data
public class ServiceRentalEntityPK implements Serializable {
    @Column(name = "serviceID")
    @Id
    private int serviceId;
    @Column(name = "roomID")
    @Id
    private int roomId;

}

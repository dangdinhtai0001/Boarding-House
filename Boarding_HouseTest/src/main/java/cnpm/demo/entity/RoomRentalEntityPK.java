package cnpm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import lombok.*;

@Data
@Builder
public class RoomRentalEntityPK implements Serializable {
    @Column(name = "customerID")
    @Id
    private int customerId;
    @Id
    @Column (name = "roomId")
    private int roomId;


}

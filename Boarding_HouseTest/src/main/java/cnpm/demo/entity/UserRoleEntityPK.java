package cnpm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import lombok.*;

@Data
@Builder
public class UserRoleEntityPK implements Serializable {
    @Column(name = "user_id")
    @Id
    private int userId;
    @Column(name = "role_id")
    @Id
    private int roleId;


}

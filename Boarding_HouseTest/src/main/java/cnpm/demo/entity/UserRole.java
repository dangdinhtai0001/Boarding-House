package cnpm.demo.entity;

import javax.persistence.*;

import lombok.*;
@Data

@Entity
@Table(name = "user_role", schema = "boarding_house")
@IdClass(UserRoleEntityPK.class)
public class UserRole {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Id
    @Column(name = "role_id")
    private int roleId;

}

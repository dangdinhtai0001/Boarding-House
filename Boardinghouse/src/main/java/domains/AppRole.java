package domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "app_role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> users;
}

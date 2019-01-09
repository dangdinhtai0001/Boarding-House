package hus.k61a3.demo.ultis.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "errors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Error {
    @Id
    @Column(name = "id")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}

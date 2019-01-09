package hus.k61a3.demo.home.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "feedback")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @NotEmpty
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "feedback", nullable = false)
    private String feedback;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "is_ignore", nullable = true)
    private Boolean isIgnore;

    public Feedback(@NotEmpty String fullname, @NotEmpty String phoneNumber, @Email String email, @NotEmpty String feedback) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.feedback = feedback;
    }
}
package hus.k61a3.demo.blog.domains;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "name", length = 16 , nullable = true )
    private String name;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "content" , nullable = false )
    private String content;

    @Column(name = "date_created")
    private Date dateCreated;
}

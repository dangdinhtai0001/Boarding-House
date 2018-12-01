package hus.k61a3.demo.blog.domains;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blog_topic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;
}

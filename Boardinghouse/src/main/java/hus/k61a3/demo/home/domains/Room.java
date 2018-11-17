package hus.k61a3.demo.home.domains;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Room")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "recommend")
    private int recommend;

    @Column(name = "floor")
    private int floor;

    @Column(name = "price")
    private double price;

    @Column(name = "square")
    private int square;

    @Column(name = "closed")
    private boolean closed;

    @Column(name = "bathroom")
    private int bathroom;

    @Column(name = "windows")
    private int windows;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;
}

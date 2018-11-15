package hus.k61a3.demo.blog.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SubmitCommentForm {
    private String name;
    private String email;
    private String message;
}

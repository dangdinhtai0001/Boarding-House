package hus.k61a3.demo.blog.entities;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SubmitCommentForm {
    @Size(max = 256)
    private String name;

    @NotEmpty
    @NotNull
    @Size(min = 1, max = 256)
    @Email
    private String email;

    @NotEmpty
    @NotNull
    private String message;

    private int parentId;

}

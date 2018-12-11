package hus.k61a3.demo.contact;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SubmitFeedbackForm {
    private String name;
    private String phoneNumber;
    private String email;
    private String content;
}

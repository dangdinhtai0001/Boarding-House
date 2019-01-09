package hus.k61a3.demo.contact;

import hus.k61a3.demo.home.domains.Feedback;
import hus.k61a3.demo.home.repositories.FeedbackRepository;
import hus.k61a3.demo.home.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ContactService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private HomeService homeService;

    private int error = 2;

    public Feedback submitfeedback(SubmitFeedbackForm form) {

        String name = form.getName();
        String email = form.getEmail();
        String phone = form.getPhoneNumber();
        String content = form.getContent();
        Feedback feedback = null;

        if (name.equals("\\s+") || email.equals("\\s+") || phone.equals("\\s+") || content.equals("\\s+")) {
            error = 1;
        } else {
            feedback = new Feedback(name, phone, email, content);
            feedbackRepository.save(feedback);
            error = 0;
        }
        return feedback;
    }
    public void displaySubmitForm(Model model, SubmitFeedbackForm submitFeedbackForm) {
        model.addAttribute("submitFeedbackForm", submitFeedbackForm);
        if(error == 1){
            model.addAttribute("message","Bạn phải nhập đầy đủ các trường....");
        }
        if(error == 0){
            model.addAttribute("message","Phản hồi của bạn đã được gửi lên hệ thống");
        }
        if(error == 2){
            model.addAttribute("message","");
        }
    }

    public void displayContactPage(Model model) {
        SubmitFeedbackForm submitFeedbackForm = new SubmitFeedbackForm();
        homeService.displayHome(model);
        displaySubmitForm(model, submitFeedbackForm);
    }

}

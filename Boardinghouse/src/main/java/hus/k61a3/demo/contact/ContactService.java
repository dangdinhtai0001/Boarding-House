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

    public boolean submitfeedback(SubmitFeedbackForm form) {

        String name = form.getName();
        String email = form.getEmail();
        String phone = form.getPhoneNumber();
        String content = form.getContent();

        if (name.equals("\\s+") || email.equals("\\s+") || phone.equals("\\s+") || content.equals("\\s+")) {
            error = 1;
        } else {
            feedbackRepository.save(new Feedback(name, phone, email, content));
            error = 0;
        }
        return error==0;
    }

    public void displayContactPage(Model model) {
        SubmitFeedbackForm submitFeedbackForm = new SubmitFeedbackForm();
        homeService.displayHome(model);
        model.addAttribute("submitFeedbackForm", submitFeedbackForm);
        if(error == 1){
            model.addAttribute("message","Bạn phải nhập đầy đủ các trường....");
        }if(error == 0){
            model.addAttribute("message","Phản hồi của bạn đã được gửi lên hệ thống");
        }if(error == 2){
            model.addAttribute("message","");
        }
    }


}

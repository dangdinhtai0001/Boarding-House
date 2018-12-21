package hus.k61a3.demo.contact;

import hus.k61a3.demo.home.domains.Feedback;
import hus.k61a3.demo.home.services.HomeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class ContactServiceTest {
    private int error = 2;
    @Autowired
    Feedback feedback;
    @Autowired
    ContactService contactService;
    @Autowired
    SubmitFeedbackForm submitFeedbackForm;

    @Test(expected = NullPointerException.class)
    public void submitFeedbackTest1() throws Exception{
       //SubmitFeedbackForm sf = new SubmitFeedbackForm();
        //ContactService cs = new ContactService();

        submitFeedbackForm.setName("Trang");
        Assert.assertEquals("Trang",submitFeedbackForm.getName());
        submitFeedbackForm.setPhoneNumber("01672945637");
        Assert.assertEquals("01672945637",submitFeedbackForm.getPhoneNumber());
        submitFeedbackForm.setEmail("trang123@gmail.com");
        Assert.assertEquals("trang123@gmail.com",submitFeedbackForm.getEmail());
        submitFeedbackForm.setContent("Tôi đang test");
        Assert.assertEquals("Tôi đang test",submitFeedbackForm.getContent());

        Feedback feedback1= new Feedback(submitFeedbackForm.getName(),submitFeedbackForm.getPhoneNumber(),submitFeedbackForm.getEmail(),submitFeedbackForm.getContent());
        System.out.println(feedback1);

        feedback = new Feedback("Trang", "01672945637", "trang123@gmail.com","Tôi đang test");
        System.out.println(feedback);
        boolean expected = feedback.equals(feedback1);
        Assert.assertFalse(expected);

        ContactService cs = new ContactService();
        boolean result = cs.submitfeedback(submitFeedbackForm).equals(feedback);
        Assert.assertFalse(result);
    }

    @Test(expected = NullPointerException.class)
    public void submitFeedbackTest2() throws Exception{
        SubmitFeedbackForm sf = new SubmitFeedbackForm();
        sf.setName("Trang");
        sf.setPhoneNumber("");
        sf.setEmail("abc@gamil.com");
        sf.setContent("Tôi đang làm unit test");

        ContactService cs = new ContactService();

        Assert.assertEquals(sf, cs.submitfeedback(sf));
    }

    @Test(expected = NullPointerException.class)
    public void submitFeedbackTest3() throws Exception{
        SubmitFeedbackForm sf = new SubmitFeedbackForm();
        sf.setName("Trang");
        sf.setPhoneNumber("01672945637");
        sf.setEmail(" ");
        sf.setContent("Tôi đang làm unit test");

        ContactService cs = new ContactService();

        Assert.assertEquals(sf, cs.submitfeedback(sf));
    }
//    @Autowired
//    HomeService homeService;
//    @Autowired
//    Model model;
//    @Test
//    public void displayContactPageTest() throws Exception{
//      ContactService contactService = new ContactService();
//      SubmitFeedbackForm submitFeedbackForm = new SubmitFeedbackForm();
//      homeService.displayHome(model);
//      model.addAttribute("message","Hello world");
//
//
//
//    }
}

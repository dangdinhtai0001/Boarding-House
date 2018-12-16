package hus.k61a3.demo.contact;

import org.junit.Assert;
import org.junit.Test;

    public class SubmitFeedbackFormTest {
        @Test
        public final void testCreateSubmitFeedbackForm(){
            SubmitFeedbackForm submitFeedbackForm = new SubmitFeedbackForm();

            submitFeedbackForm.setName("Trang");
            submitFeedbackForm.setPhoneNumber("01672945637");
            submitFeedbackForm.setEmail("abc@gmail.com");
            submitFeedbackForm.setContent("Tôi đang làm unit test");

            Assert.assertEquals("Trang",submitFeedbackForm.getName());
            Assert.assertEquals("01672945637",submitFeedbackForm.getPhoneNumber());
            Assert.assertEquals("abc@gmail.com",submitFeedbackForm.getEmail());
            Assert.assertEquals("Tôi đang làm unit test",submitFeedbackForm.getContent());


        }
        @Test
        public final void testFeedbackNotNull(){

            SubmitFeedbackForm form = new SubmitFeedbackForm();
            form.setName("Trang");
            form.setEmail("");
            form.setPhoneNumber("01234567890");
            form.setContent("Feedback test");

            Assert.assertNotNull(form.getName());
            Assert.assertNotNull(form.getEmail());
            Assert.assertNotNull(form.getPhoneNumber());
            Assert.assertNotNull(form.getContent());

        }



}

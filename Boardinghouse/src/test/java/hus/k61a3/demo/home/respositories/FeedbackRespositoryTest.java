package hus.k61a3.demo.home.respositories;

import hus.k61a3.demo.home.domains.Feedback;
import hus.k61a3.demo.home.repositories.FeedbackRepository;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class FeedbackRespositoryTest {
    FeedbackRepository feedbackRepository = null;

    @Test(expected = NullPointerException.class)
    public void search_NoFeedbackEntriesFound_ShouldReturnEmptyList(){
        List<Feedback> feedbacks = feedbackRepository.findRandomFeedback(0);
        Assert.assertThat(feedbacks.size(), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void search_OneRoomEntryFound_ShouldReturnAListOfOneEntry(){
        List<Feedback> feedbacks = feedbackRepository.findRandomFeedback(1);
        Assert.assertThat(feedbacks.size(), is(1));
        Assert.assertThat(feedbacks.get(0), allOf(
                hasProperty("id", is(1L)),
                hasProperty("fullname", is("Nguyen Thi Ha")),
                hasProperty("phone_number", is("0123456789")),
                hasProperty("email", is("ha@gmail.com")),
                hasProperty("feedback", is("Cơ sở vật chất khá ổn"))));
    }

    @Test(expected = NullPointerException.class)
    public void search_TwoRoomEntriesFound_shouldReturnAListOfTwoEntry(){
        List<Feedback> feedbacks = feedbackRepository.findRandomFeedback(2);
        Assert.assertThat(feedbacks.size(), is(2));
        Assert.assertThat(feedbacks, contains(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("fullname", is("Nguyen Thi A")),
                        hasProperty("phone_number", is("012345678911")),
                        hasProperty("email", is("a@gmail.com")),
                        hasProperty("feedback", is("Cơ sở vật chất cũ"))),
                allOf(
                        hasProperty("id", is(2L)),
                        hasProperty("fullname", is("Nguyen Van B")),
                        hasProperty("phone_number", is("0123456789")),
                        hasProperty("email", is("ha@gmail.com")),
                        hasProperty("feedback", is("Cơ sở vật chất khá ổn")))
        ));
    }
}

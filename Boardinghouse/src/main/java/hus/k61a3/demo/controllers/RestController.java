package hus.k61a3.demo.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hus.k61a3.demo.config.HibernateProxyTypeAdapter;
import hus.k61a3.demo.contact.ContactService;
import hus.k61a3.demo.contact.SubmitFeedbackForm;
import hus.k61a3.demo.home.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private HomeService homeService;

    @Autowired
    private ContactService contactService;

    @RequestMapping("/api")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @GetMapping("/api/feedbacks")
    public String getFeedbacks() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
//        System.out.println(response);
        return gson.toJson(homeService.feedbackList());
    }


    @RequestMapping(value = "/api/submit-feedback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String submitFeedback(@RequestBody SubmitFeedbackForm form) {
        System.out.println("AAAAAAAAAAAAAA");
        System.out.println(form.getName());
//        System.out.println(request);
//        System.out.println(response);
//        Feedback feedback = contactService.submitfeedback(form);
        return form.toString();
    }
}

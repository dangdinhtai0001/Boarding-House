package hus.k61a3.demo.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hus.k61a3.demo.Listings.RoomService;
import hus.k61a3.demo.config.HibernateProxyTypeAdapter;
import hus.k61a3.demo.contact.ContactService;
import hus.k61a3.demo.home.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private HomeService homeService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private RoomService roomService;

    @RequestMapping("/api")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    private Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        return gson;
    }

    @GetMapping("/api/feedbacks")
    public String getFeedbacks() {

//        System.out.println(response);
        return getGson().toJson(homeService.feedbackList());
    }

    @RequestMapping("/api/findAllRoomByOrderBySquareDesc")
    @ResponseBody
    public String findAllRoomByOrderBySquareDesc(){
        return getGson().toJson(roomService.findAllByOrderBySquareDesc());
    }

}

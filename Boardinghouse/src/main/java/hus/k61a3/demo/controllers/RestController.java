package hus.k61a3.demo.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hus.k61a3.demo.config.HibernateProxyTypeAdapter;
import hus.k61a3.demo.home.domains.ConfigHome;
import hus.k61a3.demo.home.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private HomeService homeService;
    @GetMapping("/api/feedbacks")
    public String getHomeData(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        return gson.toJson(homeService.feedbackList());
    }
}

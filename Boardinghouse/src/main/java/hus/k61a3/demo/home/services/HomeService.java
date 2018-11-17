package hus.k61a3.demo.home.services;

import hus.k61a3.demo.home.domains.ConfigHome;
import hus.k61a3.demo.home.domains.Room;
import hus.k61a3.demo.home.repositories.FeedbackRepository;
import hus.k61a3.demo.home.repositories.HomeRepository;
import hus.k61a3.demo.home.repositories.RoomRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private HomeRepository  homeRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private RoomRepositoriy roomRepositoriy;

    public void displayHome(Model model) {
        model.addAttribute("home", homeRepository.getOne(1));
    }

    public void displayFeedback(Model model){
        model.addAttribute("feedbacks", feedbackRepository.findAll());
    }

    public void displayRoomList(Model model){
        model.addAttribute("rooms", getRoomList());
    }

    public List<Room> getRoomList(){
        return (List)roomRepositoriy.findAll();
    }

    public List<Room> findTop2(){
        return roomRepositoriy.findTop2ByOrderByPriceDesc();
    }

    public ConfigHome getHomeData(){
        return homeRepository.getOne(1);
    }
}

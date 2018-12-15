package hus.k61a3.demo.Listings;

import hus.k61a3.demo.contact.ContactService;
import hus.k61a3.demo.contact.SubmitFeedbackForm;
import hus.k61a3.demo.home.domains.Room;
import hus.k61a3.demo.home.repositories.RoomRepositoriy;
import hus.k61a3.demo.home.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepositoriy roomRepositoriy;
    @Autowired
    private HomeService homeService;
    @Autowired
    private ContactService contactService;
    private int error = 2;

    public void displayListingsPage(Model model){
        model.addAttribute("home",homeService.getHomeData());
        model.addAttribute("rooms", findAllRooms());
    }

    private List<Room> findAllRooms(){
        return roomRepositoriy.findAll();
    }

    private Room getOne(String id){
        return roomRepositoriy.getOne(Integer.parseInt(id));
    }

    public void displaySingleRoomPage(Model model, String id) {
        SubmitFeedbackForm submitFeedbackForm = new SubmitFeedbackForm();
        model.addAttribute("room", getOne(id));
        model.addAttribute("home", homeService.getHomeData());
        homeService.displayHome(model);
        contactService.displaySubmitForm(model, submitFeedbackForm);
    }

}

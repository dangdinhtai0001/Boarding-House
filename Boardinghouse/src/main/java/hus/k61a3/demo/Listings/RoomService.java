package hus.k61a3.demo.Listings;

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

    public void displayListingsPage(Model model){
        model.addAttribute("home",homeService.getHomeData());
        model.addAttribute("rooms", findAllRooms());
    }

    private List<Room> findAllRooms(){
        return roomRepositoriy.findAll();
    }

    public void displaySingleRoomPage(Model model, String id) {
        homeService.displayHome(model);
    }
}

package hus.k61a3.demo.home.services;

import hus.k61a3.demo.home.domains.ConfigHome;
import hus.k61a3.demo.home.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class HomeService {
    @Autowired
    private HomeRepository  homeRepository;

    public void displayHome(Model model) {
        model.addAttribute("home", homeRepository.getOne(1));
    }

    public ConfigHome getHomeData(){
        return homeRepository.getOne(1);
    }
}

package hus.k61a3.demo.controllers;

import hus.k61a3.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
//    UserRepository userRepository;
    private UserDetailsService userDetailsService;


    @RequestMapping(value = {"/", "/login"})
    public String login() {
        return "login2";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/admin")
    public String admin() {
//        System.out.println("RUN");
        return "admin";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
}

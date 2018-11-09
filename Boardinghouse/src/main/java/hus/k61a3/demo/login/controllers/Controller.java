package hus.k61a3.demo.login.controllers;

import hus.k61a3.demo.ultis.ErrorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
//    UserRepository userRepository;
    private UserDetailsService userDetailsService;

    @Autowired
    private ErrorServiceImp errorServiceImp;


    @RequestMapping(value = {"/", "/login"})
    public String login() {
//        System.out.println(rememberMe.toString());
        return "login";
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
    public String accessDenied(Model model) {
//        System.out.println(errorServiceImp.getOne("403").toString());
        model.addAttribute("error",errorServiceImp.getOne("403"));
        return "errors";
    }
}

package hus.k61a3.demo.controllers;

import hus.k61a3.demo.blog.entities.Post;
import hus.k61a3.demo.blog.services.BlogService;
import hus.k61a3.demo.ultis.services.ErrorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
//    UserRepository userRepository;
    private UserDetailsService userDetailsService;

    @Autowired
    private ErrorServiceImp errorServiceImp;

    @Autowired
    private BlogService blogService;

//    private Pos


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

    @RequestMapping("/blog")
    public String blog() {
//        System.out.println(errorServiceImp.getOne("403").toString());
            List<Post> posts =blogService.getAllPost();
        for (Post post: posts) {
            System.out.println(post.getPost().getContent());
            System.out.println("-----------------------------------");
            System.out.println(post.getComments().toString());
        }
//        return "errors";
        return "test";
    }
}

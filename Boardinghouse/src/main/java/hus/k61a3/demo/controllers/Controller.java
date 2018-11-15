package hus.k61a3.demo.controllers;

import hus.k61a3.demo.blog.entities.Post;
import hus.k61a3.demo.blog.entities.SubmitCommentForm;
import hus.k61a3.demo.blog.services.BlogService;
import hus.k61a3.demo.ultis.services.ErrorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ErrorServiceImp errorServiceImp;

    @Autowired
    private BlogService blogService;


    @RequestMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/403")
    public String accessDenied(Model model) {
        model.addAttribute("error", errorServiceImp.getOne("403"));
        return "errors";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Blog
    //https://shareeverythings.com/lap-trinh/java/huong-dan-phan-trang-trong-thymeleaf-va-spring-boot/
    @RequestMapping("/blog")
    public String blog(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        request.getSession().setAttribute("postList", null);
        model.addAttribute("title","HOME | BLOG");
        return "redirect:/blog/page/1";
    }

    @RequestMapping("/blog/page/{pageNumber}")
    public String pagination(HttpServletRequest request, @PathVariable String pageNumber, Model model) {
        blogService.pagination(model,request,pageNumber);
        return "blog";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/blog/post/{id}", method = RequestMethod.GET)
    public String singleBlog(@PathVariable String id,Model model){
        blogService.displaySinglePost(model,id);
        return "singleBlog";
    }


}

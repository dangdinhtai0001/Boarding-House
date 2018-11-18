package hus.k61a3.demo.controllers;

import hus.k61a3.demo.Listings.ListingsService;
import hus.k61a3.demo.blog.entities.SubmitCommentForm;
import hus.k61a3.demo.blog.services.BlogService;
import hus.k61a3.demo.home.services.HomeService;
import hus.k61a3.demo.ultis.services.ErrorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ErrorServiceImp errorServiceImp;

    @Autowired
    private BlogService blogService;

    @Autowired
    private HomeService homeService;

    @Autowired
    private ListingsService listingsService;

//    @Autowired
//    private RoomService roomService;


    @RequestMapping(value = {"/login"})
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
        model.addAttribute("title", "HOME | BLOG");
        return "redirect:/blog/page/1";
    }

    @RequestMapping("/blog/page/{pageNumber}")
    public String pagination(HttpServletRequest request, @PathVariable String pageNumber, Model model) {
        blogService.displayBlog(request, pageNumber, model,homeService);
        return "blog";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/blog/post/{id}", method = RequestMethod.GET)
    public String singleBlog(@PathVariable String id, Model model) {
        blogService.displaySinglePost(model, id,homeService);
        return "singleBlog";
    }

    @RequestMapping(value = "/blog/post/{id}/submit", method = RequestMethod.POST)
    public String submitComment(@ModelAttribute("submitCommentForm") SubmitCommentForm form, @PathVariable String id
                                , Model model) {
        blogService.submitComment(form, Integer.parseInt(id),model);
        return "redirect:/blog/post/{id}";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = {"/home","/"} , method = RequestMethod.GET)
    public String home(Model model){
        homeService.displayHome(model);
        homeService.displayFeedback(model);
        homeService.displayRoomList(model, 6);
        return "home";
    }

    @RequestMapping(value = "/listings")
    public String listings(Model model){
        listingsService.displayListingsPage(model);
        return "listings";
    }
}

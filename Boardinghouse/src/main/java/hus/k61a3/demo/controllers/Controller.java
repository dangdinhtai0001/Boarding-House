package hus.k61a3.demo.controllers;

import hus.k61a3.demo.Listings.RoomService;
import hus.k61a3.demo.blog.entities.SubmitCommentForm;
import hus.k61a3.demo.blog.services.BlogService;
import hus.k61a3.demo.contact.ContactService;
import hus.k61a3.demo.contact.SubmitFeedbackForm;
import hus.k61a3.demo.home.services.HomeService;
import hus.k61a3.demo.ultis.services.ErrorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private RoomService roomService;

    @Autowired
    private ContactService contactService;
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
    public String blog(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("postList", null);
        model.addAttribute("title", "HOME | BLOG");
        return "redirect:/blog/page/1";
    }

    @RequestMapping("/blog/page/{pageNumber}")
    public String pagination(HttpServletRequest request, @PathVariable String pageNumber, Model model) {
        blogService.displayBlog(request, pageNumber, model, homeService);
        return "blog";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/blog/post/{id}", method = RequestMethod.GET)
    public String singleBlog(@PathVariable String id, Model model) {
        blogService.displaySinglePost(model, id);
        return "singleBlog";
    }

    @RequestMapping(value = "/blog/post/{id}/submit", method = RequestMethod.POST)
    public String submitComment(@ModelAttribute("submitCommentForm") SubmitCommentForm form, @PathVariable String id) {
        blogService.submitComment(form, Integer.parseInt(id));
        return "redirect:/blog/post/{id}";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String home(Model model) {
        homeService.displayHomePage(model, 6);
        return "home";
    }

    @RequestMapping(value = "/listings")
    public String listings(Model model) {
        roomService.displayListingsPage(model);
        return "listings";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        contactService.displayContactPage(model);
        return "contact";
    }

    @RequestMapping(value = "/contact/submit", method = RequestMethod.POST)
    public String submitFeedback(@ModelAttribute("submitFeedbackForm") SubmitFeedbackForm form, Model model) {
        contactService.submitfeedback(form);
        return "redirect:/contact";
    }

    @RequestMapping(value = "/2048")
    public String game2048(Model model) {
        homeService.displayHome(model);
        return "game2048";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(path = "/listings/room/{id}", method = RequestMethod.GET)
    public String singleRoom(@PathVariable("id") String id, Model model) {
        roomService.displaySingleRoomPage(model, id);
        return "singleListings";
    }


}

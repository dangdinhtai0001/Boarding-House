package hus.k61a3.demo.controllers;

import hus.k61a3.demo.blog.entities.Post;
import hus.k61a3.demo.blog.services.BlogService;
import hus.k61a3.demo.ultis.services.ErrorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    //Dùng cho phân trang
    private static int pageSize = 3;


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
        PagedListHolder<?> pagedListHolder = (PagedListHolder<?>) request.getSession().getAttribute("postList");
        List<Post> list = blogService.getAllPost();

        //Chưa rõ nguyên nhân lỗi
        int pageNumberInt = 1;
        if (String.valueOf(pageNumber).contains("null")) {
            pageNumber = pageNumber.substring(4);
//            System.out.println(pageNumber.substring(4,pageNumber.length()));
        }
        pageNumberInt = Integer.parseInt(pageNumber);


        if (pagedListHolder == null) {
            pagedListHolder = new PagedListHolder<>(list);
            pagedListHolder.setPageSize(pageSize);
        } else {
            final int goToPage = pageNumberInt - 1;
            if (goToPage <= pagedListHolder.getPageCount() && goToPage >= 0) {
                pagedListHolder.setPage(goToPage);
            }
        }

        request.getSession().setAttribute("postList", pagedListHolder);
        int current = pagedListHolder.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + pageSize, pagedListHolder.getPageCount());
        int totalPageCount = pagedListHolder.getPageCount();
        String baseURL = "/blog/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseURL", baseURL);
        model.addAttribute("posts", pagedListHolder);

        return "blog";
    }

    @RequestMapping(value = "/blog/post/{id}", method = RequestMethod.GET)
    public String singleBlog(@PathVariable String id){
        System.out.println(blogService.getOne(id));
//        System.out.println(id);
        return "layout";
    }

}

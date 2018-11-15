package hus.k61a3.demo.blog.services;

import hus.k61a3.demo.blog.entities.Post;
import hus.k61a3.demo.blog.entities.SubmitCommentForm;
import hus.k61a3.demo.blog.repositories.CommentRepository;
import hus.k61a3.demo.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    protected CommentRepository commentRepository;

    //Dùng cho phân trang
    private static int pageSize = 3;

    private List<Post> getAllPost() {
        List<Post> posts = new ArrayList<>();
        for (hus.k61a3.demo.blog.domains.Post post : postRepository.findAll()) {
            Post post1 = new Post(post, commentRepository.findByPostId(post.getId()));
            posts.add(post1);
        }
        return posts;
    }

    private Post getOne(String id) {
        try {
            return new Post(postRepository.findById(Integer.parseInt(id)), commentRepository.findByPostId(Integer.parseInt(id)));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void displaySinglePost(Model model, String id) {
        model.addAttribute("post", getOne(id));
        SubmitCommentForm form = new SubmitCommentForm();
        model.addAttribute("submitCommentForm", form);
        model.addAttribute("error", true);
        model.addAttribute("errorMessage", "Test lỗi ");
    }


    public void pagination(Model model, HttpServletRequest request, String pageNumber) {
        PagedListHolder<?> pagedListHolder = (PagedListHolder<?>) request.getSession().getAttribute("postList");
        List<Post> list = getAllPost();

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
    }

    


}

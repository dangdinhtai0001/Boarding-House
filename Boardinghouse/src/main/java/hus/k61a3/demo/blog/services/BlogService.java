package hus.k61a3.demo.blog.services;

import hus.k61a3.demo.blog.entities.Post;
import hus.k61a3.demo.blog.repositories.CommentRepository;
import hus.k61a3.demo.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<Post> getAllPost(){
        List<Post> posts = new ArrayList<>();
        for (hus.k61a3.demo.blog.domains.Post post: postRepository.findAll()) {
            Post post1 = new Post(post, commentRepository.findByPostId(post.getId()));
            posts.add(post1);
        }
        return posts;
    }
}

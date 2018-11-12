package hus.k61a3.demo.blog.services;

import hus.k61a3.demo.blog.entities.Post;
import hus.k61a3.demo.blog.repositories.CommentRepository;
import hus.k61a3.demo.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<Post> getAllPost(){
//        System.out.println(postRepository.findAll());
//        System.out.println(commentRepository.findAll());
//        System.out.println(commentRepository.findByPostId(1));
        List<Post> posts = new ArrayList<>();
        for (hus.k61a3.demo.blog.domains.Post post: postRepository.findAll()) {
            Post post1 = new Post(post, commentRepository.findByPostId(post.getId()));
            posts.add(post1);
        }
        return posts;
    }
}

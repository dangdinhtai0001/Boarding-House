package hus.k61a3.demo.blog.repositories;

import hus.k61a3.demo.blog.domains.Comment;
import hus.k61a3.demo.blog.domains.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByPostId(int id);
}

package hus.k61a3.demo.blog.repositories;

import hus.k61a3.demo.blog.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByParentIdAndAndPostId(int parentId, int postId);
    List<Comment> findByPostId(int id);
    Comment save(Comment comment);
}

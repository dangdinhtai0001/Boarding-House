package hus.k61a3.demo.blog.repositories;

import hus.k61a3.demo.blog.domains.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}

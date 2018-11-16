package hus.k61a3.demo.blog.repositories;

import hus.k61a3.demo.blog.domains.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}

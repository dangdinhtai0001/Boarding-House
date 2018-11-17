package hus.k61a3.demo.home.repositories;

import hus.k61a3.demo.home.domains.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}

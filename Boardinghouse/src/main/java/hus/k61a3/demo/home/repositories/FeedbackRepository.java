package hus.k61a3.demo.home.repositories;

import hus.k61a3.demo.home.domains.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    Feedback save(Feedback feedback);
    @Query(value="SELECT * FROM feedback ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<Feedback> findRandomFeedback(int limit);
}

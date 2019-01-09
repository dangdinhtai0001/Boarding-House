package hus.k61a3.demo.home.repositories;

import hus.k61a3.demo.home.domains.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepositoriy extends JpaRepository<Room,Integer> {
    @Query(value="SELECT * FROM room ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<Room> findRandomRoom(int limit);

    List<Room> findAllByOrderBySquareDesc();
}

package hus.k61a3.demo.home.repositories;

import hus.k61a3.demo.home.domains.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepositoriy extends JpaRepository<Room,Integer> {
    List<Room> findTop2ByOrderByPriceDesc();
}

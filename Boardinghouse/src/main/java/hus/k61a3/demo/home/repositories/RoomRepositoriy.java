package hus.k61a3.demo.home.repositories;

import hus.k61a3.demo.home.domains.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepositoriy extends JpaRepository<Room,Integer> {
}

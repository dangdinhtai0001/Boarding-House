package hus.k61a3.demo.home.repositories;

import hus.k61a3.demo.home.domains.ConfigHome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<ConfigHome,Integer> {

}

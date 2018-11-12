package hus.k61a3.demo.login.repositories;

import hus.k61a3.demo.login.domains.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}

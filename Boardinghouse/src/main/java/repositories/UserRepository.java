package repositories;

import domains.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}

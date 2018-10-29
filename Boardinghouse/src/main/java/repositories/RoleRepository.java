package repositories;

import domains.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<AppRole, Integer> {
    AppRole findByName(String name);
}

package hus.k61a3.demo.login.repositories;

import hus.k61a3.demo.login.domains.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Integer> {
    AppRole findByName(String name);
}

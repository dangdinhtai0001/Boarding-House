package hus.k61a3.demo.repositories;

import hus.k61a3.demo.domains.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Integer> {
    AppRole findByName(String name);
}

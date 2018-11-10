package hus.k61a3.demo.ultis.repositories;

import hus.k61a3.demo.ultis.domains.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error,String> {
}

package webportfolio.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webportfolio.myapp.model.Backend;

@Repository
public interface BackendRepo extends JpaRepository<Backend, Long> {
}

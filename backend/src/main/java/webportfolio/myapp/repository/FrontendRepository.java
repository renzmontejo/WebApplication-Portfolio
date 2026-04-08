package webportfolio.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webportfolio.myapp.model.Frontend;

@Repository
public interface FrontendRepo extends JpaRepository<Frontend, Long> {
}

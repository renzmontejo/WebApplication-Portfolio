package webportfolio.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webportfolio.myapp.model.Tools;

@Repository
public interface ToolsRepo extends JpaRepository<Tools, Long> {
}

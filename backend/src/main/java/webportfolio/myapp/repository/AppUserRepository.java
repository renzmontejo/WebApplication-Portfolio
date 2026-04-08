package webportfolio.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webportfolio.myapp.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}

package com.myapp.portfolio.backend.repository;

import com.myapp.portfolio.backend.model.Technology;
import com.myapp.portfolio.backend.model.TechnologyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);
    List<Technology> findByCategory(TechnologyCategory category);
}
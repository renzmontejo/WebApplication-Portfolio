package com.myapp.portfolio.backend.repository;

import com.myapp.portfolio.backend.model.PortfolioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioServiceRepository extends JpaRepository<PortfolioService, Long> {
}
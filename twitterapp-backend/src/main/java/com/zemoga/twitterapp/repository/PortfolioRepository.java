package com.zemoga.twitterapp.repository;

import com.zemoga.twitterapp.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    Portfolio findPortfolioByIdPortfolio(long id);
}

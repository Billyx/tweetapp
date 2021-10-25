package com.zemoga.twitterapp.service;

import com.zemoga.twitterapp.model.Portfolio;
import com.zemoga.twitterapp.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicePortfolio {

    @Autowired
    PortfolioRepository portfolioRepository;

    public List<Portfolio> getAllPortfolio(){
        return portfolioRepository.findAll();
    }
    public Portfolio findPortfolioBydId(long idPortfolio){
        return portfolioRepository.findPortfolioByIdPortfolio(idPortfolio);
    }
    public Portfolio savePortfolio(Portfolio p){
        return portfolioRepository.save(p);
    }
}

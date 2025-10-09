package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEEquityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEEquityService {
    @Autowired
    NSEEquityRepo nseEquityRepo;

    public List<NSEEquity> getNseEquityList(){
        return nseEquityRepo.findAll();
    }
}

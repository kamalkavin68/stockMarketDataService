package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEIndustriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEIndustriesService {

    @Autowired
    NSEIndustriesRepo nseIndustriesRepo;

    public List<NSEIndustries> getAllIndustries() {
        return nseIndustriesRepo.findAll();
    }
}

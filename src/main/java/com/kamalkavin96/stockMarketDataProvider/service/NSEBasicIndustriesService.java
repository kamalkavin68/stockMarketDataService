package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.model.NSEBasicIndustries;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEBasicIndustriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEBasicIndustriesService {

    @Autowired
    NSEBasicIndustriesRepo nseBasicIndustriesRepo;

    public List<NSEBasicIndustries> getAllBasicIndustries() {
        return nseBasicIndustriesRepo.findAll();
    }
}

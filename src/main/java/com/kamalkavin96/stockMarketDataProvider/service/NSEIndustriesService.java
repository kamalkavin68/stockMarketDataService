package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.exception.NotFoundException;
import com.kamalkavin96.stockMarketDataProvider.model.NSEBasicIndustries;
import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEBasicIndustriesRepo;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEIndustriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEIndustriesService {

    @Autowired
    NSEIndustriesRepo nseIndustriesRepo;

    @Autowired
    NSEBasicIndustriesRepo nseBasicIndustriesRepo;

    public List<NSEIndustries> getAllIndustries() {
        return nseIndustriesRepo.findAll();
    }

    public List<NSEBasicIndustries> getAllBasicIndustriesForIndustries(Integer industriesId){
        nseIndustriesRepo.findById(industriesId).orElseThrow(() -> new NotFoundException("Industries is not found for ID: " + industriesId));
        return nseBasicIndustriesRepo.findAllBasicIndustriesForIndustries(industriesId);
    }

}

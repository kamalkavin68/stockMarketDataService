package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.exception.NotFoundException;
import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEIndustriesRepo;
import com.kamalkavin96.stockMarketDataProvider.repository.NSESectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSESectorService {
    @Autowired
    NSESectorRepo nseSectorRepo;

    @Autowired
    NSEIndustriesRepo nseIndustriesRepo;

    public List<NSESector> getAllSectors() {
        return nseSectorRepo.findAll();
    }

    public List<NSEIndustries> getAllIndustriesForSector(Integer sectorId){
        nseSectorRepo.findById(sectorId).orElseThrow(() -> new NotFoundException("Sector not found with ID: " + sectorId));
        return nseIndustriesRepo.findIndustriesBySectorId(sectorId);
    }
}

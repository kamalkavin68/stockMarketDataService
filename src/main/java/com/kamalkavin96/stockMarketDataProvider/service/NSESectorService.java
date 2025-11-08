package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import com.kamalkavin96.stockMarketDataProvider.repository.NSESectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSESectorService {
    @Autowired
    NSESectorRepo nseSectorRepo;

    public List<NSESector> getAllSectors() {
        return nseSectorRepo.findAll();
    }
}

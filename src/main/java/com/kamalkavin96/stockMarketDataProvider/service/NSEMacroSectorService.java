package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.model.NSEMacroSector;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEMacroSectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEMacroSectorService {

    @Autowired
    NSEMacroSectorRepo nseMacroSectorRepo;

    public List<NSEMacroSector> getAllMacroSectors() {
        return nseMacroSectorRepo.findAll();
    }
}

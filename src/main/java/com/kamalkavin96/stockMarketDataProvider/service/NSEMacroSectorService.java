package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.exception.NotFoundException;
import com.kamalkavin96.stockMarketDataProvider.model.NSEMacroSector;
import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEMacroSectorRepo;
import com.kamalkavin96.stockMarketDataProvider.repository.NSESectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEMacroSectorService {

    @Autowired
    NSEMacroSectorRepo nseMacroSectorRepo;

    @Autowired
    NSESectorRepo nseSectorRepo;

    public List<NSEMacroSector> getAllMacroSectors() {
        return nseMacroSectorRepo.findAll();
    }

    public List<NSESector> getAllSectorForMacroSector(Integer macroSectorId){
        nseMacroSectorRepo.findById(macroSectorId).orElseThrow(() -> new NotFoundException("Macro-Sector not found with ID: "+macroSectorId));
        return nseSectorRepo.findSectorsByMacroSectorId(macroSectorId);
    }

}

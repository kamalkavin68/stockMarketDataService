package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.exception.NotFoundException;
import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEEquityRepo;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEMacroSectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NSEEquityService {
    @Autowired
    NSEEquityRepo nseEquityRepo;

    @Autowired
    NSEMacroSectorRepo nseMacroSectorRepo;

    public List<NSEEquity> getNseEquityList(){
        return nseEquityRepo.findAll();
    }

    public NSEEquity getNseEquityMeta(String symbol){
        return nseEquityRepo.findBySymbol(symbol).orElse(null);
    }

    public List<NSEEquity> searchEquity(String symbol){
        return nseEquityRepo.searchBySymbolPrefix(symbol);
    }

    public List<NSEEquity> findAllEquityUNderMacroSector(Integer macroSectorId){
        nseMacroSectorRepo.findById(macroSectorId).orElseThrow(() -> new NotFoundException("Macro-Sector not found with ID: "+macroSectorId));
        return nseEquityRepo.findEquityForMacroSector(macroSectorId);
    }
}

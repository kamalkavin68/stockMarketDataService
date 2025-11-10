package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.dto.NSEWeeklyScanResponseDTO;
import com.kamalkavin96.stockMarketDataProvider.exception.NotFoundException;
import com.kamalkavin96.stockMarketDataProvider.model.NSEStockPerformance;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEStockPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSEStockPerformanceService {

    @Autowired
    NSEStockPerformanceRepository nseStockPerformanceRepository;

    public NSEStockPerformance getBySymbolId(Long symbolId) {
        return nseStockPerformanceRepository.findBySymbolId(symbolId).orElseThrow(()-> new NotFoundException("Stock Performance not found for ID: "+ symbolId));
    }

    public List<NSEWeeklyScanResponseDTO> getWeeklyScan(Float percentage) {
        List<Object[]> result = nseStockPerformanceRepository.findWeeklyScan(percentage);
        return result.stream()
                .map(row -> new NSEWeeklyScanResponseDTO(
                        (String) row[0],
                        ((Number) row[1]).doubleValue()
                ))
                .toList();
    }

}

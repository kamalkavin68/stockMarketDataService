package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.dto.NSEWeeklyScanResponseDTO;
import com.kamalkavin96.stockMarketDataProvider.model.NSEStockPerformance;
import com.kamalkavin96.stockMarketDataProvider.service.NSEStockPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nse/equity-performance")
public class NSEStockPerformanceController {

    @Autowired
    NSEStockPerformanceService nseStockPerformanceService;

    @GetMapping("/get-by-id/{symbolId}")
    public ResponseEntity<NSEStockPerformance> getPerformanceBySymbolId(@PathVariable Long symbolId) {
        return ResponseEntity.status(HttpStatus.OK).body( nseStockPerformanceService.getBySymbolId(symbolId));
    }

    @GetMapping("/scan/weekly")
    public ResponseEntity<List<NSEWeeklyScanResponseDTO>> getPerformanceScanner(@RequestParam Float percentage) {
        return ResponseEntity.status(HttpStatus.OK).body( nseStockPerformanceService.getWeeklyScan(percentage));
    }


}

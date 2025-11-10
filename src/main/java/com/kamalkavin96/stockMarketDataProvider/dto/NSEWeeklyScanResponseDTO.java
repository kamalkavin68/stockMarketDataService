package com.kamalkavin96.stockMarketDataProvider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NSEWeeklyScanResponseDTO {
    private String symbol;
    private Double perf1w;
}

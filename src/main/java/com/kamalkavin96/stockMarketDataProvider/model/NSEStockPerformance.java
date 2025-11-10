package com.kamalkavin96.stockMarketDataProvider.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "nse_stock_performance_v1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NSEStockPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol_id", nullable = false)
    private Long symbolId;

    @Column(name = "perf_1w")
    private Double perf1w;

    @Column(name = "perf_1m")
    private Double perf1m;

    @Column(name = "perf_3m")
    private Double perf3m;

    @Column(name = "perf_6m")
    private Double perf6m;

    @Column(name = "perf_9m")
    private Double perf9m;

    @Column(name = "perf_1y")
    private Double perf1y;

    @Column(name = "perf_2y")
    private Double perf2y;

    @Column(name = "perf_3y")
    private Double perf3y;

    @Column(name = "perf_4y")
    private Double perf4y;

    @Column(name = "perf_5y")
    private Double perf5y;

    @Column(name = "perf_10y")
    private Double perf10y;

    @Column(name = "perf_15y")
    private Double perf15y;

    @Column(name = "perf_20y")
    private Double perf20y;

    @Column(name = "perf_all_time")
    private Double perfAllTime;
}

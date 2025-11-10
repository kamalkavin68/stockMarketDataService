package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSEStockPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NSEStockPerformanceRepository extends JpaRepository<NSEStockPerformance, Long> {
    Optional<NSEStockPerformance> findBySymbolId(Long symbolId);

    @Query(value = """
    SELECT e.symbol, sp.perf_1w
    FROM nse_stock_performance_v1 sp
    JOIN nse_equity_v1 e ON sp.symbol_id = e.id
    WHERE
        (
            :percentage >= 0 AND sp.perf_1w >= :percentage
        )
        OR
        (
            :percentage < 0 AND sp.perf_1w <= :percentage
        )
    """, nativeQuery = true)
    List<Object[]> findWeeklyScan(Float percentage);
}

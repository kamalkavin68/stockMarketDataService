package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NSEEquityRepo extends JpaRepository<NSEEquity, Long> {
    Optional<NSEEquity> findBySymbol(String symbol);

    @Query(
            value = "SELECT * FROM nse_equity_v1 e " +
                    "WHERE LOWER(e.symbol) LIKE LOWER(CONCAT(:prefix, '%')) " +
                    "   OR LOWER(e.name_of_company) LIKE LOWER(CONCAT('%', :prefix, '%'))",
            nativeQuery = true
    )
    List<NSEEquity> searchBySymbolPrefix(@Param("prefix") String prefix);

}

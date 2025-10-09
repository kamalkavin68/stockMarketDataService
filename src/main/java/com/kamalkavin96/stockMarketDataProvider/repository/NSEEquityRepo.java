package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSEEquityRepo extends JpaRepository<NSEEquity, Long> {
}

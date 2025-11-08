package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSEBasicIndustries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSEBasicIndustriesRepo extends JpaRepository<NSEBasicIndustries, Integer> {
}

package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSEBasicIndustries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NSEBasicIndustriesRepo extends JpaRepository<NSEBasicIndustries, Integer> {

    @Query(value = "SELECT * FROM nse_basic_industries_v1 WHERE industry_id = :industriesId", nativeQuery = true)
    List<NSEBasicIndustries> findAllBasicIndustriesForIndustries(Integer industriesId);
}

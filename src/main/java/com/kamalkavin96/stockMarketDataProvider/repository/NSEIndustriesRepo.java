package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NSEIndustriesRepo extends JpaRepository<NSEIndustries, Integer> {

    @Query(value = "SELECT * FROM nse_industries_v1 WHERE sector_id = :sectorId", nativeQuery = true)
    List<NSEIndustries> findIndustriesBySectorId(Integer sectorId);
}

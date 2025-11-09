package com.kamalkavin96.stockMarketDataProvider.repository;

import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NSESectorRepo extends JpaRepository<NSESector, Integer> {

    @Query(value = "SELECT * FROM nse_sectors_v1 WHERE macro_sector_id = :macroSectorId", nativeQuery = true)
    List<NSESector> findSectorsByMacroSectorId(Integer macroSectorId);
}

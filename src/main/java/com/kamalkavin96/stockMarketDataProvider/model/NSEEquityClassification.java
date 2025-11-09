package com.kamalkavin96.stockMarketDataProvider.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nse_equity_classification_v1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NSEEquityClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "equity_id", nullable = false)
    Long equityId;
    @Column(name = "macro_sector_id", nullable = false)
    Integer macroSectorId;
}

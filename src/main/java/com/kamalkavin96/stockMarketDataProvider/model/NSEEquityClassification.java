package com.kamalkavin96.stockMarketDataProvider.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nse_equity_classification_v1")
public class NSEEquityClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "equity_id", nullable = false, referencedColumnName = "id")
    @JsonManagedReference
    private NSEEquity equity;

    @ManyToOne
    @JoinColumn(name = "macro_sector_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private NSEMacroSector macroSector;



}

package com.kamalkavin96.stockMarketDataProvider.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nse_equity_v1")
public class NSEEquity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true, nullable = false, length = 100, name = "symbol")
    private String symbol;
    @Column(name = "name_of_company", nullable = false)
    private String nameOfCompany;
    @Column(name = "series", nullable = false)
    private String series;
    @Column(name = "date_of_listing", nullable = false)
    private LocalDate dateOfListing;
    @Column(name = "paid_up_value", nullable = false)
    private int paidUpValue;
    @Column(name = "market_lot", nullable = false)
    private int marketLot;
    @Column(name = "isin_number", nullable = false)
    private String isinNumber;
    @Column(name = "face_value", nullable = false)
    private int faceValue;

    @OneToOne(mappedBy = "equity", cascade = CascadeType.ALL)
    @JsonBackReference
    private NSEEquityClassification classification;


}

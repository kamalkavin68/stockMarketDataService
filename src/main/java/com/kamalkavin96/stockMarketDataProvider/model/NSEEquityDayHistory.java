package com.kamalkavin96.stockMarketDataProvider.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "nse_day_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NSEEquityDayHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "symbol_id", nullable = false)
    private Integer symbolId;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(name = "open", nullable = false)
    private Float open;

    @Column(name = "high", nullable = false)
    private Float high;

    @Column(name = "low", nullable = false)
    private Float low;

    @Column(name = "close", nullable = false)
    private Float close;

    @Column(name = "volume", nullable = false)
    private Long volume;
}

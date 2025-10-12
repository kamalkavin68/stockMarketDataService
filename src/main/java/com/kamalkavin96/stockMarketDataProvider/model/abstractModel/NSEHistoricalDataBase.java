package com.kamalkavin96.stockMarketDataProvider.model.abstractModel;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class NSEHistoricalDataBase {

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;
    @Column
    private float open;
    @Column
    private float high;
    @Column
    private float low;
    @Column
    private float close;
    @Column
    private Long volume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equity_id", nullable = false)
    private NSEEquity equity;
}

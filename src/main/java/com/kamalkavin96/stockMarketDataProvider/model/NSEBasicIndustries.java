package com.kamalkavin96.stockMarketDataProvider.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "nse_basic_industries_v1")
public class NSEBasicIndustries {

    @Id
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 225)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "logo_name", length = 255)
    private String logoName;

    @Column(name = "industry_id", nullable = false)
    private Integer macroSectorId;

}

package com.kamalkavin96.stockMarketDataProvider.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kamalkavin96.stockMarketDataProvider.model.abstractModel.NSEClassificationBase;
import jakarta.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "id")
@Entity
@Table(name = "nse_basic_industries_v1")
public class NSEBasicIndustries extends NSEClassificationBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_id", nullable = false)
    @JsonBackReference
    private NSEIndustries industry;

}

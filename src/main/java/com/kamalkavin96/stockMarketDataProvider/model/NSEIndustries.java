package com.kamalkavin96.stockMarketDataProvider.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kamalkavin96.stockMarketDataProvider.model.abstractModel.NSEClassificationBase;
import jakarta.persistence.*;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "id")
@Entity
@Table(name = "nse_industries_v1")
public class NSEIndustries  extends NSEClassificationBase {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    @JsonBackReference
    private NSESector sector;

    @OneToMany(mappedBy = "industry", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<NSEBasicIndustries> basicIndustries;

}

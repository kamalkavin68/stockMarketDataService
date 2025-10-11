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
@Table(name = "nse_sectors_v1")
public class NSESector extends NSEClassificationBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "macro_sector_id", nullable = false)
    @JsonBackReference
    private NSEMacroSector macroSector;

    @OneToMany(mappedBy = "sector" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<NSEIndustries> industries;

}

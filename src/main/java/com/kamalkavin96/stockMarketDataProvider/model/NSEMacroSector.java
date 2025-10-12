package com.kamalkavin96.stockMarketDataProvider.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kamalkavin96.stockMarketDataProvider.model.abstractModel.NSEClassificationBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "id")
@Entity
@Table(name = "nse_macro_sectors_v1")
public class NSEMacroSector extends NSEClassificationBase {

    @OneToMany(mappedBy = "macroSector", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<NSESector> sectors;

    @OneToMany(mappedBy = "macroSector", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<NSEEquityClassification> equityClassifications;

}

package com.kamalkavin96.stockMarketDataProvider.model;

import com.kamalkavin96.stockMarketDataProvider.model.abstractModel.NSEClassificationBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "nse_macro_sectors_v1")
public class NSEMacroSector extends NSEClassificationBase {

}

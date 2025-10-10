package com.kamalkavin96.stockMarketDataProvider.model;

import com.kamalkavin96.stockMarketDataProvider.model.abstractModel.NSEClassificationBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "nse_industries_v1")
public class NSEIndustries  extends NSEClassificationBase {
}

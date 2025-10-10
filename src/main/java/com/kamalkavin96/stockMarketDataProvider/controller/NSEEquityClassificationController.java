package com.kamalkavin96.stockMarketDataProvider.controller;


import com.kamalkavin96.stockMarketDataProvider.model.NSEBasicIndustries;
import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.model.NSEMacroSector;
import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import com.kamalkavin96.stockMarketDataProvider.service.NSEBasicIndustriesService;
import com.kamalkavin96.stockMarketDataProvider.service.NSEIndustriesService;
import com.kamalkavin96.stockMarketDataProvider.service.NSEMacroSectorService;
import com.kamalkavin96.stockMarketDataProvider.service.NSESectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nse/classification")
public class NSEEquityClassificationController {

    @Autowired
    NSEMacroSectorService nseMacroSectorService;

    @Autowired
    NSESectorService nseSectorService;

    @Autowired
    NSEIndustriesService nseIndustriesService;

    @Autowired
    NSEBasicIndustriesService nseBasicIndustriesService;

    @GetMapping("/macro-sector")
    public List<NSEMacroSector> getMacroSectorsMapping(){
        return nseMacroSectorService.getAllMacroSector();
    }

    @GetMapping("/sectors")
    public  List<NSESector> getNseSectorsMapping(){
        return nseSectorService.getAllSectors();
    }

    @GetMapping("/industries")
    public List<NSEIndustries> getNseIndustriesMapping(){
        return  nseIndustriesService.getAllIndustries();
    }

    @GetMapping("/basic-industries")
    public List<NSEBasicIndustries> getNseBasicIndustriesMapping(){
        return nseBasicIndustriesService.getAllBasicIndustries();
    }


}

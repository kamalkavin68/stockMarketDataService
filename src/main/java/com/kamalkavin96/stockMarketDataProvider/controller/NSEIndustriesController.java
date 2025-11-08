package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.service.NSEIndustriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/industries")
public class NSEIndustriesController {

    @Autowired
    NSEIndustriesService nseIndustriesService;

    @GetMapping("/get-all")
    public List<NSEIndustries> getAllIndustriesMapping(){
        return nseIndustriesService.getAllIndustries();
    }
}

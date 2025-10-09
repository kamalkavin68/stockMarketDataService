package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import com.kamalkavin96.stockMarketDataProvider.service.NSEEquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/nse")
public class NSEEquityController {

    @Autowired
    NSEEquityService nseEquityService;

    @GetMapping("/equity-list")
    public List<NSEEquity> getNSEEquityListMapping(){
        return nseEquityService.getNseEquityList();
    }

}

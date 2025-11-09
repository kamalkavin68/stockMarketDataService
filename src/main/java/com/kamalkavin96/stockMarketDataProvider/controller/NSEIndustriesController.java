package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEIndustries;
import com.kamalkavin96.stockMarketDataProvider.service.NSEIndustriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<NSEIndustries>> getAllIndustriesMapping(){
        return ResponseEntity.status(HttpStatus.OK).body(nseIndustriesService.getAllIndustries());
    }
}

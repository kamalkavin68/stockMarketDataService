package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEBasicIndustries;
import com.kamalkavin96.stockMarketDataProvider.service.NSEBasicIndustriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basic-industries")
public class NSEBasicIndustriesController {

    @Autowired
    NSEBasicIndustriesService nseBasicIndustriesService;

    @GetMapping("/get-all")
    public ResponseEntity<List<NSEBasicIndustries>> getAllBasicIndustriesMapping(){
        return ResponseEntity.status(HttpStatus.OK).body(nseBasicIndustriesService.getAllBasicIndustries());
    }
}

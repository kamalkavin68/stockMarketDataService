package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import com.kamalkavin96.stockMarketDataProvider.service.NSESectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sector")
public class NSESectorController {

    @Autowired
    NSESectorService nseSectorService;

    @GetMapping("/get-all")
    public List<NSESector> getAllSectorMapping(){
        return nseSectorService.getAllSectors();
    }
}

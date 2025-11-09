package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEMacroSector;
import com.kamalkavin96.stockMarketDataProvider.model.NSESector;
import com.kamalkavin96.stockMarketDataProvider.service.NSEMacroSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/macro-sector")
public class NSEMacroSectorController {

    @Autowired
    NSEMacroSectorService nseMacroSectorService;

    @GetMapping("/get-all")
    public ResponseEntity<List<NSEMacroSector>> getAllMacroSector(){
        return ResponseEntity.status(HttpStatus.OK).body(nseMacroSectorService.getAllMacroSectors());
    }

    @GetMapping("/get-sectors/{macroSectorId}")
    public  ResponseEntity<List<NSESector>> getAllSectors(@PathVariable Integer macroSectorId){
        return ResponseEntity.status(HttpStatus.OK).body(nseMacroSectorService.getAllSectorForMacroSector(macroSectorId));
    }


}

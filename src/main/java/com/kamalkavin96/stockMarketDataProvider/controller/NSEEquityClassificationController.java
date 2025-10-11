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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/nse/classification")
public class NSEEquityClassificationController {

    @Value("${redis.caching.enable}")
    private boolean redisCachingEnabled;

    @Autowired
    NSEMacroSectorService nseMacroSectorService;

    @Autowired
    NSESectorService nseSectorService;

    @Autowired
    NSEIndustriesService nseIndustriesService;

    @Autowired
    NSEBasicIndustriesService nseBasicIndustriesService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/macro-sector")
    public List<NSEMacroSector> getMacroSectorsMapping(){

        String cacheKey = "cache:macro-sector";
        if (redisCachingEnabled){
            List<NSEMacroSector> cachedData = (List<NSEMacroSector>) redisTemplate.opsForValue().get(cacheKey);
            if (cachedData != null) {
                System.out.println("Returning cached macro sectors");
                return cachedData;
            }
        }
        List<NSEMacroSector> data = nseMacroSectorService.getAllMacroSector();
        if (redisCachingEnabled){
            redisTemplate.opsForValue().set(cacheKey, data, 1, TimeUnit.HOURS);
            System.out.println("Caching macro sectors");
        }
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

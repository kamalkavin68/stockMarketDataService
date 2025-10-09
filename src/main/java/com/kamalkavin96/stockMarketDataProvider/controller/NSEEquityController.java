package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import com.kamalkavin96.stockMarketDataProvider.service.NSEEquityService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("api/v1/nse")
public class NSEEquityController {

    @Autowired
    NSEEquityService nseEquityService;

    private final Logger logger = LoggerFactory.getLogger(NSEEquityController.class);

    @GetMapping("/equity-list")
    public List<NSEEquity> getNSEEquityListMapping(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            logger.info("Header: {} = {}", headerName, headerValue);
        }
        logger.info("");
        logger.info("Processing getNSEEquityListMapping GET Request");
        return nseEquityService.getNseEquityList();
    }

}

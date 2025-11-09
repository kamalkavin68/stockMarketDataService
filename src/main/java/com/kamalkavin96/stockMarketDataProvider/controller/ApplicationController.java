package com.kamalkavin96.stockMarketDataProvider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class ApplicationController {

    private final Instant startTime = Instant.now();
    private final DataSource dataSource;

    public ApplicationController(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @GetMapping("/info")
    public Map<String, Object> appInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Stock Market Data Provider");
        map.put("version", "1.0.0");
        map.put("description", "Provides real-time and historical stock market data");
        map.put("environment", System.getProperty("spring.profiles.active"));
        return map;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "UP");
        return map;
    }

    @GetMapping("/system-metrics")
    public Map<String, Object> systemMetrics() {
        Map<String, Object> metrics = new HashMap<>();

        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        Runtime runtime = Runtime.getRuntime();

        // CPU Usage
        double systemLoad = os.getSystemLoadAverage(); // system load average
        int cores = os.getAvailableProcessors();

        // Memory Usage
        long freeMem = runtime.freeMemory();
        long totalMem = runtime.totalMemory();
        long maxMem = runtime.maxMemory();

        metrics.put("uptime_seconds", (Instant.now().getEpochSecond() - startTime.getEpochSecond()));

        Map<String, Object> cpu = new HashMap<>();
        cpu.put("system_load_average", systemLoad);
        cpu.put("available_cores", cores);

        Map<String, Object> memory = new HashMap<>();
        memory.put("free_memory_mb", freeMem / 1024 / 1024);
        memory.put("total_memory_mb", totalMem / 1024 / 1024);
        memory.put("max_memory_mb", maxMem / 1024 / 1024);
        memory.put("used_memory_mb", (totalMem - freeMem) / 1024 / 1024);

        metrics.put("cpu", cpu);
        metrics.put("memory", memory);

        return metrics;
    }

    @GetMapping("/db-status")
    public Map<String, Object> dbStatus() {
        Map<String, Object> db = new HashMap<>();
        try (Connection conn = dataSource.getConnection()) {
            db.put("status", "UP");
            db.put("database_product", conn.getMetaData().getDatabaseProductName());
            db.put("database_version", conn.getMetaData().getDatabaseProductVersion());
        } catch (Exception e) {
            db.put("status", "DOWN");
            db.put("error", e.getMessage());
        }
        return db;
    }
}

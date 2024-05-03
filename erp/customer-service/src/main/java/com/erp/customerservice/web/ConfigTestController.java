package com.erp.customerservice.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import com.erp.customerservice.config.GlobalConfig;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class ConfigTestController {
    private final GlobalConfig globalConfig;

    @Value("${customer.params.x}")
    private String x;
    @Value("${customer.params.y}")
    private String y;

    @GetMapping("/config-test")
    public Map<String, ?> getConfigTest() {
        return Map.of("x", x, "y", y);
    }

    @GetMapping("/global-config")
    public GlobalConfig getConfig() {
        return globalConfig;
    }

}

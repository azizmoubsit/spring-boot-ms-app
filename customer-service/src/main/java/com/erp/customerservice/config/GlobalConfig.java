package com.erp.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "global.params")
@Getter
@Setter
public class GlobalConfig {
    private int p1;
    private int p2;
}

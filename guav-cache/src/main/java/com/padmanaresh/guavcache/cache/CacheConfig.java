package com.padmanaresh.guavcache.cache;

import java.util.concurrent.TimeUnit;

import com.padmanaresh.guavcache.model.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public CacheStore<Employee> employeeCache(CacheLoaderService<Employee> employeeService) {
        return new CacheStore<>(120, TimeUnit.SECONDS, employeeService);
    }
    
}

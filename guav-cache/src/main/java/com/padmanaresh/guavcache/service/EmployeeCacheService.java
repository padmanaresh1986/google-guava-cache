package com.padmanaresh.guavcache.service;

import java.util.concurrent.TimeUnit;

import com.padmanaresh.guavcache.cache.CacheLoaderService;
import com.padmanaresh.guavcache.model.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeCacheService implements CacheLoaderService<Employee>{

    @Override
    public Employee getBackendData(String id) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Employee(id,"Naresh","Engineer");
    }
    
}

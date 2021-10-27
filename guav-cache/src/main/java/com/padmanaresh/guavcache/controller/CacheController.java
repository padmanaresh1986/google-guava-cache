package com.padmanaresh.guavcache.controller;

import java.util.concurrent.ExecutionException;

import com.padmanaresh.guavcache.cache.CacheStore;
import com.padmanaresh.guavcache.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    CacheStore<Employee> employeeCache;


    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
         try {
            Employee empRecord = employeeCache.get(id);
            return empRecord;
        } catch (ExecutionException e) {
            return null;
        }
    }

}

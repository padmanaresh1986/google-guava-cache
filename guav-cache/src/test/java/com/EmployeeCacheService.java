package com;

import com.padmanaresh.guavcache.cache.CacheLoaderService;
import com.padmanaresh.guavcache.model.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeCacheService implements CacheLoaderService<Employee>{

    @Override
    public Employee getBackendData(String id) {
        try
        {
            //Simulate backend service by forcing thread to sleep
            System.out.println("Going to sleep for 5 Secs... to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Return dummy Employee record
        return new Employee(id,"Employee Name " + id ,"Engineer");
    }
    
}

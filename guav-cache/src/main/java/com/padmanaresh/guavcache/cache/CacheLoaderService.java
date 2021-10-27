package com.padmanaresh.guavcache.cache;

public interface CacheLoaderService<T> {
    T getBackendData(String id);    
}

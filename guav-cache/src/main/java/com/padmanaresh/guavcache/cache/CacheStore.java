package com.padmanaresh.guavcache.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheStore<T> {
    private LoadingCache<String, T> loadingCache;
    
    public CacheStore(int expiryDuration, TimeUnit timeUnit, CacheLoaderService<T> service){
        CacheLoader<String, T> loader = new CacheLoader<String, T>() {
            @Override
            public T load(String key) {
                return service.getBackendData(key);
            }
        };        
        loadingCache = CacheBuilder.newBuilder()
        .expireAfterWrite(expiryDuration, timeUnit)
        .concurrencyLevel(Runtime.getRuntime().availableProcessors())
        .build(loader);
    }
    public T get(java.lang.String key) throws ExecutionException {
        return loadingCache.get(key);
    }
    
}

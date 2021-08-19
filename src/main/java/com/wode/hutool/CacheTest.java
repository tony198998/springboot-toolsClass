package com.wode.hutool;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import org.junit.Test;

public class CacheTest {

    @Test
    public void cacheUtil(){
        Cache<String, String> cache = CacheUtil.newFIFOCache(3);
        cache.put("a","11");
        cache.put("b","11");
        cache.put("c","11");
        cache.put("d","11");
        System.out.println(cache);
    }
}

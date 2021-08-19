package com.wode.async;

import club.hongsong.arch.async.executor.Async;
import club.hongsong.arch.async.wrapper.WorkerWrapper;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AsyncTest {

    int id = 10000000;

    @Test
    public void TestAsync() throws ExecutionException, InterruptedException {
        Worker worker = new Worker();
        Param param = Param.builder().id(id).build();
        WorkerWrapper<Param, List<String>> wrapper = new WorkerWrapper.Builder<Param, List<String>>()
                .worker(worker)
                .callback(worker)
                .param(param)
                .build();
        Async.beginWork(3000, wrapper);
        List<String> result = wrapper.getWorkResult().getResult();
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test() {
        Long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < id; i++) {
            result.add("test:" + i);
        }

        Long end = System.currentTimeMillis();
        System.out.println("同步消耗：" + (end - start));
    }

    @Test
    public void test1(){
         int[] ints = new int[]{1,2,3};

        ints[1] &= ~(1 << 3);
        System.out.println(ints);


    }

}

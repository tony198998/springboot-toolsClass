package com.wode.async;

import club.hongsong.arch.async.callback.ICallback;
import club.hongsong.arch.async.callback.IWorker;
import club.hongsong.arch.async.worker.WorkResult;
import club.hongsong.arch.async.wrapper.WorkerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Worker implements IWorker<Param, List<String>>, ICallback<Param, List<String>> {

    private long timestamp;


    @Override
    public void begin() {
        timestamp = System.currentTimeMillis();
    }

    @Override
    public void result(boolean b, Param param, WorkResult<List<String>> workResult) {
        long spend = System.currentTimeMillis() - timestamp;
        System.out.println("消耗时间：" + spend);
    }

    @Override
    public List<String> action(Param param, Map<String, WorkerWrapper> map) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < param.getId(); i++) {
            result.add("test:" + i);
        }
        return result;
    }
}

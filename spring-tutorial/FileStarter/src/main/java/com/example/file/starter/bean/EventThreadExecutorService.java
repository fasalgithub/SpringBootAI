package com.example.file.starter.bean;

import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class EventThreadExecutorService {

    public void process() {
        EventThreadExecutorService executorService = new EventThreadExecutorService();
        System.out.println(executorService.returnIntegerValuesInThread());
    }

    private int returnIntegerValuesInThread() {
        int number = 0;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int num = 0; num <= 10; num++) {
                    result = num;
                }
                return result;
            }
        });

        try {
            number = result.get();
        } catch (Exception e) {
            System.out.println(e);
        }

        return number;
    }
}

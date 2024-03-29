package com.example.file.starter.service;

import com.example.file.starter.bean.MyFileAlterationListener;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@RequiredArgsConstructor
//@Component
public class MyEventListener {
    @Autowired
    private final MyFileAlterationListener myFileAlterationListener;
    @Autowired
    private Environment environment;

    public List<String> process(File file) {

        /*

        Thread accessThread = null;
        synchronized (myFileAlterationListener) {
            accessThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    myFileAlterationListener.getMyContents().forEach(System.out::println);
                    myFileAlterationListener.getMyContents().clear();
                }
            }, "Access Thread");
        }
        accessThread.start();

        */

        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(Optional.ofNullable(environment.getProperty("file-path")).orElse(file.getAbsolutePath()));
        FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(5000);
        fileAlterationObserver.addListener(myFileAlterationListener);
        fileAlterationMonitor.addObserver(fileAlterationObserver);

        try {
            fileAlterationMonitor.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Future<List<String>> future = null;
        synchronized (myFileAlterationListener) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            future = executorService.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    return myFileAlterationListener.getMyContents();
                }
            });
        }
        try {
            return future.get();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return Collections.emptyList();
    }
}

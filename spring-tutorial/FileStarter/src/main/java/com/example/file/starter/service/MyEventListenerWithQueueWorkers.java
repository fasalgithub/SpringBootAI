package com.example.file.starter.service;

import com.example.file.starter.bean.MyFileAlterationListener;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class MyEventListenerWithQueueWorkers {
    @Autowired
    private final MyFileAlterationListener myFileAlterationListener;
    @Autowired
    private Environment environment;

    public void process(File file) {

        Thread accessThread = null;
        synchronized (myFileAlterationListener) {
            accessThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    if (!CollectionUtils.isEmpty(myFileAlterationListener.getMyContents())) {
                        myFileAlterationListener.getMyContents().forEach(System.out::println);
                        myFileAlterationListener.getMyContents().clear();
                    }
                }
            }, "Access Thread");
        }

        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(Optional.ofNullable(environment.getProperty("file-path")).orElse(file.getAbsolutePath()));
        FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(5000);
        fileAlterationObserver.addListener(myFileAlterationListener);
        fileAlterationMonitor.addObserver(fileAlterationObserver);

        try {
            fileAlterationMonitor.start();
            accessThread.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

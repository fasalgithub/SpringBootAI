package com.usthealthproof.commons.starters.storage.listener;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileEventListener {

    @Autowired
    private MyFileAlterationListener myFileAlterationListener;

    public void startProcess(String path) {

        Thread accessThread = null;
        synchronized (myFileAlterationListener) {
            accessThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    myFileAlterationListener.getMyContents().forEach(System.out::println);
                    myFileAlterationListener.getMyContents().clear();
                }
            }, "Access Thread");
        }

        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(path);
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

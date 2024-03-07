package com.example.file.starter.bean;

import com.example.file.starter.service.MyFirstUnivocity;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

@Service
public class MyFileAlterationListener implements FileAlterationListener {
    private final MyFirstUnivocity myFirstUnivocity;
    private List<String> listOfContent;

    @Autowired
    MyFileAlterationListener(MyFirstUnivocity myFirstUnivocity) {
        this.myFirstUnivocity = myFirstUnivocity;
        this.listOfContent = Collections.synchronizedList(new ArrayList<>());
    }


    @Override
    public synchronized void onDirectoryChange(File file) {

    }

    @Override
    public synchronized void onDirectoryCreate(File file) {

    }

    @Override
    public synchronized void onDirectoryDelete(File file) {

    }

    @Override
    public synchronized void onFileChange(File file) {
        System.out.println("file modified :" + file.getName());
    }

    @Override
    public synchronized void onFileCreate(File file) {
        System.out.println("file created :" + file.getName());
    }

    @Override
    public synchronized void onFileDelete(File file) {
        System.out.println("file deleted :" + file.getName());
    }

    @Override
    public synchronized void onStart(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver.getDirectory().exists()) {
            Arrays.stream(Objects.requireNonNull(fileAlterationObserver.getDirectory().listFiles())).filter(fileFiler -> Files.isRegularFile(fileFiler.toPath()))
                    .forEach(regularFile -> {
                        try {
                            System.out.println(" on start ");
                            String content = myFirstUnivocity.readTxtFile(regularFile);
                            listOfContent.add(content);
                            regularFile.delete();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }

    @Override
    public synchronized void onStop(FileAlterationObserver fileAlterationObserver) {
//        listOfContent.clear();
    }

    public synchronized List<String> getMyContents() {
        return this.listOfContent;
    }


}

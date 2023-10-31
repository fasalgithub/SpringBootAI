package com.usthealthproof.commons.starters.storage.listener;

import com.usthealthproof.commons.starters.storage.core.validation.helper.FileReaderHelper;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class MyFileAlterationListener extends FileAlterationListenerAdaptor {
    private final FileReaderHelper fileReaderHelper;
    private List<String> listOfContent = null;

    @Autowired
    MyFileAlterationListener(FileReaderHelper fileReaderHelper) {
        this.fileReaderHelper = fileReaderHelper;
        this.listOfContent = new ArrayList<>();
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
                            String content = fileReaderHelper.processByFileFormat(regularFile);
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
        listOfContent.clear();
    }

    public synchronized List<String> getMyContents() {
        return this.listOfContent;
    }
}
package com.usthealthproof.commons.starters.storage.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.usthealthproof.commons.starters.storage.core.validation.helper.FileReaderHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileListener {
    @Autowired
    FileReaderHelper fileReaderHelper;

//    @EventListener(ApplicationReadyEvent.class)
    public void listenForNewFile(String listenRootPath) throws JsonProcessingException {
        File directory = new File(listenRootPath);
        File[] existingFiles = directory.listFiles();
        FileAlterationObserver observer = new FileAlterationObserver(listenRootPath);
        log.info("Start ACTIVITY, Monitoring " + listenRootPath);
        observer.addListener(new FileAlterationListenerAdaptor() {
            @Override
            public void onDirectoryChange(File file) {
                log.info("onDirectoryChange:{}", file.getName());
            }

            @Override
            public void onDirectoryCreate(File file) {
                log.info("onDirectoryCreate:{}", file.getName());
            }

            @Override
            public void onDirectoryDelete(File file) {
                log.info("onDirectoryDelete:{}", file.getName());
            }

            @Override
            public void onFileChange(File file) {
                log.info("onFileChange:{}", file.getName());
            }

            @Override
            public void onFileCreate(File file) {
                try {
                    log.info("onFileCreate:{}", file.getName());
                    fileReaderHelper.processByFileFormat(file);
                } catch (IOException io) {
                    log.error("Error Processing Listened File:{}", file.getName() + ":" + io.getMessage());
                    io.printStackTrace();
                } finally {
                    file.delete();
                }
            }

            @Override
            public void onFileDelete(File file) {
                log.info("onFileDelete:{}", file.getName());
            }

            @Override
            public void onStart(FileAlterationObserver fileAlterationObserver) {
                log.info("onStart:{}");
            }

            /*@Override
            public void onStop(FileAlterationObserver fileAlterationObserver) {
                log.info("onStop:{}");
            }*/
        });

        FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(500, observer);
        try {
            fileAlterationMonitor.start();
        } catch (Exception e) {
            log.error("Unable to monitor server :{}", e.getMessage());
            e.printStackTrace();
        }

        if (existingFiles != null) {
            Arrays.stream(existingFiles)
                    .filter(File::isFile).forEach(file -> {
                        try {
                            fileReaderHelper.processByFileFormat(file);
                        } catch (IOException e) {
                            log.error("Unable to Process Existing Files :{}", e.getMessage());
                            e.printStackTrace();
                        }
                    });
        }
    }
}

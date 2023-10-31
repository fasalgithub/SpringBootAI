package com.usthealthproof.commons.starters.storage.application;

import com.usthealthproof.commons.starters.storage.api.StorageReader;
import com.usthealthproof.commons.starters.storage.api.StorageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ApplicationReader implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    StorageReader storageReader;

    @Autowired
    StorageWriter storageWriter;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        if (event instanceof ApplicationStartedEvent) {
            List<String> resultList = null;
            try {
                resultList = storageReader.readContentAsString("S3:C:\\Users\\214487\\Desktop\\ListenRoot", "", "");
                int count = 0;
                for (String response : resultList) {
                    count++;
                    storageWriter.writeContentAsFile(response, "file:", "C:\\Users\\214487\\Desktop\\LogRoot1\\demo", "resultList" + count + ".txt");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

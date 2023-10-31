package com.usthealthproof.commons.starters.storage.service.filestorage;

import com.usthealthproof.commons.starters.storage.core.abstracts.Writer;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Slf4j
public class FileStorageWriter implements Writer {
    public void archiveAsFile(String content, String bucketName, String writeFilePath, String fileName) {
        try {
            Path writeBucketNamePath = Paths.get(bucketName);
            Path filePath = Paths.get(writeFilePath + '/' + fileName);
            Path result = filePath.resolve(filePath);
            File file = result.toFile();
            file.getParentFile().mkdirs();
            Files.writeString(result, content, StandardOpenOption.CREATE);
        } catch (Exception e) {
            log.error("WriteFileToLocalStorage Exception:{}", e.getMessage());
        }
    }

    @Override
    public void writeToStorage(String body, String bucketName, String folderPath, String fileName) {
        archiveAsFile(body, bucketName, folderPath, fileName);
    }
}

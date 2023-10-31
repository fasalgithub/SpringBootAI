package com.usthealthproof.commons.starters.storage.service.s3storage;

import com.usthealthproof.commons.starters.storage.core.abstracts.AbstarctS3Client;
import com.usthealthproof.commons.starters.storage.core.abstracts.Writer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@NoArgsConstructor
public class S3StorageWriter extends AbstarctS3Client implements Writer {

    public void writeFileToBucketLocation(String body, String bucketName, String folderPathInBucket, String fileName) {
        log.info("Writing File : " + fileName + " to : " + bucketName);
        if (Objects.nonNull(folderPathInBucket)) {
//            getAmazonS3Client().putObject(bucketName, folderPathInBucket.concat(fileName), body);
        } else {
            log.info("received empty value for folderPathInBucket.");
        }
    }

    @Override
    public void writeToStorage(String body, String bucketName, String folderPathInBucket, String fileName) {
        writeFileToBucketLocation(body, bucketName, folderPathInBucket, fileName);
    }
}

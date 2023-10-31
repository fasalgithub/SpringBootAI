package com.usthealthproof.commons.starters.storage.core.factory;

import com.usthealthproof.commons.starters.storage.constants.StorageTypeEnum;
import com.usthealthproof.commons.starters.storage.core.abstracts.Writer;
import com.usthealthproof.commons.starters.storage.service.filestorage.FileStorageWriter;
import com.usthealthproof.commons.starters.storage.service.s3storage.S3StorageWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StorageWriterFactory {

    private FileStorageWriter localStorageFileWriter = null;

    private S3StorageWriter storageFileWriter = null;

    public Writer getWriter(StorageTypeEnum storageTypeEnum) {
        if (StorageTypeEnum.FILE.equals(storageTypeEnum)) {
            if (null == localStorageFileWriter) {
                localStorageFileWriter = new FileStorageWriter();
            }
            return localStorageFileWriter;
        } else if (StorageTypeEnum.S3.equals(storageTypeEnum)) {
            if (null == storageFileWriter) {
                storageFileWriter = new S3StorageWriter();
            }
            return storageFileWriter;
        } else {
            log.error("Invalid Storage Type");
            return null;
        }
    }
}

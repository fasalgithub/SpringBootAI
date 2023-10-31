package com.usthealthproof.commons.starters.storage.core.factory;

import com.usthealthproof.commons.starters.storage.constants.StorageTypeEnum;
import com.usthealthproof.commons.starters.storage.core.abstracts.Reader;
import com.usthealthproof.commons.starters.storage.core.validation.helper.FileReaderHelper;
import com.usthealthproof.commons.starters.storage.service.filestorage.FileStorageReader;
import com.usthealthproof.commons.starters.storage.service.s3storage.S3StorageReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StorageReaderFactory {

    @Autowired
    FileReaderHelper fileReaderHelper;

    private FileStorageReader localStorageFileReader = null;

    private S3StorageReader s3StorageFileReader = null;

    /*@Autowired
    StorageReaderFactory(FileStorageReader fileStorageReader, S3StorageReader s3StorageReader){
        localStorageFileReader =  fileStorageReader;
        s3StorageFileReader = s3StorageReader;
    }*/

    public Reader getReader(StorageTypeEnum storageTypeEnum) {
        if (StorageTypeEnum.FILE.equals(storageTypeEnum)) {
            if (null == localStorageFileReader) {
                localStorageFileReader = new FileStorageReader(fileReaderHelper);
            }
            return localStorageFileReader;
        } else if (StorageTypeEnum.S3.equals(storageTypeEnum)) {
            if (null == s3StorageFileReader) {
                s3StorageFileReader = new S3StorageReader();
            }
            return s3StorageFileReader;
        } else {
            log.error("Invalid Storage Type");
            return null;
        }
    }
}

package com.usthealthproof.commons.starters.storage.service.s3storage;

import com.usthealthproof.commons.starters.storage.core.abstracts.AbstarctS3Client;
import com.usthealthproof.commons.starters.storage.core.abstracts.Reader;

import java.io.IOException;
import java.util.List;

public class S3StorageReader extends AbstarctS3Client implements Reader {

    @Override
    public List<String> readFromStorage(String filePath, String fileName) throws IOException {
        return null;
    }
}

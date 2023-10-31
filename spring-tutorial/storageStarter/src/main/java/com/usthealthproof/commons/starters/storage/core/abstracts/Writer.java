package com.usthealthproof.commons.starters.storage.core.abstracts;

public interface Writer {
    public abstract void writeToStorage(String body, String bucketName, String folderPathInBucket, String fileName);
}

package com.usthealthproof.commons.starters.storage.constants;

public enum StorageTypeEnum {
    S3,
    FILE;

    public static StorageTypeEnum fromValue(String v) {
        return StorageTypeEnum.valueOf(v.toUpperCase());
    }
}

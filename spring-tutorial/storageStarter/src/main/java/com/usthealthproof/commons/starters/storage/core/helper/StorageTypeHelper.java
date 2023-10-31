package com.usthealthproof.commons.starters.storage.core.helper;

import com.usthealthproof.commons.starters.storage.constants.StorageTypeEnum;
import org.apache.commons.lang3.StringUtils;

public class StorageTypeHelper {

    public static StorageTypeEnum extractStorageType(String folder) {
        return StorageTypeEnum.fromValue(StringUtils.substringBefore(folder, ":"));
    }
}

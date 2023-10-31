package com.usthealthproof.commons.starters.storage.api;

import com.usthealthproof.commons.starters.storage.constants.StorageTypeEnum;
import com.usthealthproof.commons.starters.storage.core.abstracts.Reader;
import com.usthealthproof.commons.starters.storage.core.factory.StorageReaderFactory;
import com.usthealthproof.commons.starters.storage.core.helper.StorageTypeHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class StorageReader {

    @Autowired
    StorageReaderFactory fileReaderFactory;

    public List<String> readContentAsString(String rootFolder, String subFolder, String fileName) throws IOException {
        StorageTypeEnum storageTypeEnum = StorageTypeHelper.extractStorageType(rootFolder);
        Reader fileReader = fileReaderFactory.getReader(storageTypeEnum);
        String folder = null;
        if (Objects.nonNull(rootFolder)) {
            rootFolder = StringUtils.substringAfter(rootFolder, ":");
            if (Objects.nonNull(subFolder))
                folder = rootFolder.concat(subFolder);
            else
                folder = rootFolder;
        }
        return fileReader.readFromStorage(folder, fileName);
    }
}

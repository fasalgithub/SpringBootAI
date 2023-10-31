package com.usthealthproof.commons.starters.storage.api;

import com.usthealthproof.commons.starters.storage.constants.StorageTypeEnum;
import com.usthealthproof.commons.starters.storage.core.abstracts.Writer;
import com.usthealthproof.commons.starters.storage.core.factory.StorageWriterFactory;
import com.usthealthproof.commons.starters.storage.core.helper.StorageTypeHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StorageWriter {

    @Autowired
    StorageWriterFactory fileWriterFactory;

    public void writeContentAsFile(String body, String rootFolder, String subFolder, String fileName) {
        StorageTypeEnum storageTypeEnum = StorageTypeHelper.extractStorageType(rootFolder);
        Writer fileWriter = fileWriterFactory.getWriter(storageTypeEnum);
        String baseFolder = null;
        if (Objects.nonNull(rootFolder)) {
            rootFolder = StringUtils.substringAfter(rootFolder, ":");
            if (Objects.nonNull(subFolder))
                baseFolder = rootFolder.concat(subFolder);
            else
                baseFolder = rootFolder;
        }

        if (storageTypeEnum.FILE.equals(storageTypeEnum))
            fileWriter.writeToStorage(body, rootFolder, baseFolder, fileName);
        else
            fileWriter.writeToStorage(body, baseFolder, subFolder, fileName);
    }
}

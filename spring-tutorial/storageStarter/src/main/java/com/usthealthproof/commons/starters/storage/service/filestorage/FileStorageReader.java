package com.usthealthproof.commons.starters.storage.service.filestorage;

import com.usthealthproof.commons.starters.storage.core.abstracts.Reader;
import com.usthealthproof.commons.starters.storage.core.validation.helper.FileReaderHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Slf4j
@AllArgsConstructor
public class FileStorageReader implements Reader {

    private FileReaderHelper fileReaderHelper;

    public static List<String> fetchFileNames(String filePath) throws IOException {
        File inputFilesInDirectory = new File(filePath);
        Stream<Path> stream = Files.list(Paths.get(String.valueOf(inputFilesInDirectory)));
        return stream
                .filter(file -> !Files.isDirectory(file))
                .map(Path::getFileName)
                .map(Path::toString)
                .toList();
    }

    public List<String> readFileContent(String readFilePath, String readFileName) throws IOException {
        ArrayList<String> resultContent = new ArrayList<>();
        if (StringUtils.isBlank(readFileName) && StringUtils.isNotBlank(readFilePath)) {
            List<String> fileNameList = fetchFileNames(readFilePath);
            if (!isEmpty(fileNameList)) {
                log.info("File processing is in progress");
                for (String fileName : fileNameList) {
                    resultContent.add(readFile(new File(readFilePath + File.separator + fileName)));
                }
            } else {
                log.info("No files present in the given directory");
            }
        } else if (StringUtils.isNotBlank(readFileName) && StringUtils.isNotBlank(readFilePath)) {
            resultContent.add(readFile(new File(readFilePath + File.separator + readFileName)));
        } else {
            log.info("FilePath is Mandatory");
        }
        return resultContent;
    }

    private String readFile(File file) throws IOException {
        if (file.exists()) {
            return fileReaderHelper.processByFileFormat(file);
        } else {
            log.info("File does not exist");
            return null;
        }
    }

    @Override
    public List<String> readFromStorage(String filePath, String fileName) throws IOException {
        return readFileContent(filePath, fileName);
    }
}

package com.usthealthproof.commons.starters.storage.core.validation.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileFormatIdentifier {
    public static String getFileFormat(File file) {
        if (file.exists()) {
            String fileName = file.getName();
            String fileExtension = getFileExtension(fileName);

            switch (fileExtension) {
                case ".xlsx", ".xls" -> {
                    log.info("This is an Excel file.");
                    return ".xls";
                }
                case ".csv" -> {
                    log.info("This is a CSV file.");
                    return ".csv";
                }
                case ".txt" -> {
                    log.info("This is a Text file.");
                    return ".txt";
                }
                default -> {
                    log.info("Unknown file type.");
                    return "unknownType";
                }
            }
        } else {
            log.info("File does not exist.");
            return null;
        }
    }

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return fileName.substring(lastDotIndex);
        }
        return "";
    }
}

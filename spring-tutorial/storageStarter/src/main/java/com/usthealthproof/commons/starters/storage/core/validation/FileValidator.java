package com.usthealthproof.commons.starters.storage.core.validation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileValidator {

    public static Boolean isExist(File file) {
        return file.exists();
    }

    public static Boolean isFile(File file) throws IOException {
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        return basicFileAttributes.isRegularFile();
    }

    public static Boolean isDirectory(File file) throws IOException {
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        return basicFileAttributes.isDirectory();
    }

    public static Boolean canRead(File file) {
        return file.canRead();
    }

    public static Boolean canWrite(File file) {
        return file.canWrite();
    }

    public static String getName(File file) {
        return file.getName();
    }

    public static String readContent(File file) throws IOException {
        return Files.readString(file.toPath(), StandardCharsets.ISO_8859_1);
    }

    public static byte[] readContentAsByte(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    public static List<File> getAllFilesByFormat(File file, String extension) {
        return Stream.of(Objects.requireNonNull(file.listFiles((fileName, name) ->
                name.endsWith(extension)))).collect(Collectors.toList());
    }

    public static Boolean isDeleted(File file) throws IOException {
        return Files.deleteIfExists(file.toPath());
    }

    public static Boolean makeDirectoryIfNotExist(File file) {
        return isExist(file) ? false : file.mkdir();
    }

}

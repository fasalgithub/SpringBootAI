package com.example.file.starter.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class FileHandler {
    public void process(File file) {
        try {
            fileReader(file);
        } catch (Exception e) {
            log.info("Message {}", e.getMessage());
        }
    }

    private void fileReader(File file) throws IOException, TikaException, SAXException {

        if (file.exists()) {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            System.out.println("file Exists");
            if (basicFileAttributes.isRegularFile() && file.canRead()) {

                     System.out.println("Can Read");
//                  Files.readAllLines(file.toPath());
//                  printNameWithContent(Collections.singletonMap(file.getName(), Files.readString(file.toPath(), StandardCharsets.ISO_8859_1)));
                    printContent(getTikaContentAndCharset(file));
//                  Files.deleteIfExists(file.toPath());

//                  Stream.of(Objects.requireNonNull(file.listFiles((fileName, name) -> name.endsWith("txt")))).collect(Collectors.toList());


            } else if (basicFileAttributes.isDirectory()) {
                Map<String, String> actualFiles;
                List<Path> filePaths = Collections.synchronizedList(Files.list(file.toPath()).filter(Files::isRegularFile).toList());
                if (filePaths.stream().findAny().isPresent()) {
                    Map<String, String> files = filePaths.stream()
                            .limit(10)
                            .collect(Collectors.toMap(path -> path.getFileName().toString(), path ->
                            {
                                String content = "";
                                try {
                                    content = Files.readString(path);
//                                    Files.deleteIfExists(path);
                                    if (StringUtils.isBlank(content))
                                        throw new IOException("File Name : {" + path.getFileName() + "} ERROR (File content is empty)");
                                } catch (IOException exception) {
                                    exception.printStackTrace();
                                }
                                return content;
                            }));
                    printNameWithContent(files);

                }


            }
        }
    }

    private void printNameWithContent(Map<String, String> contents) {
        contents.forEach((k, v) -> System.out.println(k + "-> " + v));
    }

    private void printContent(String content){
        System.out.println("content :"+content);
    }

    private void fileWriter(File folderPath, Map<String, String> contents, String exn) {
        contents.forEach((k, v) -> {
            try {
                writeFile(folderPath, v, k, exn);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private String writeFile(File file, String content, String name, String exn) throws IOException {
        if (!file.exists()) System.out.println("Folder is create : " + file.mkdir());
        else System.out.println("Folder is already created");
        Path filePath = Path.of(file.getAbsolutePath().concat(name).concat(".").concat(exn));
        Files.writeString(filePath, content);
        return null;
    }

    private String getTikaContentAndCharset(File file) throws IOException, TikaException, SAXException {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        parser.parse(new FileInputStream(file), handler, metadata, context);
        Arrays.asList(metadata.names()).forEach(System.out::println);
        return handler.toString();
    }
}

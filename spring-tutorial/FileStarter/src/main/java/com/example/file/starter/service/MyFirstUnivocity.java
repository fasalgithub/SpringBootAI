package com.example.file.starter.service;

import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class MyFirstUnivocity {


    public void process(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                List<File> files = Arrays.asList(Objects.requireNonNull(file.listFiles()));
                files.forEach(f -> {
                    try {
                        printContent(readTxtFile(f));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                try {
                    printContent(readTxtFile(file));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String readFlatFile(File file) {
        try (Reader inputReader = new InputStreamReader(new FileInputStream(file))) {
            FixedWidthFields fieldLengths = new FixedWidthFields(1);
            FixedWidthParserSettings settings = new FixedWidthParserSettings(fieldLengths);

            FixedWidthParser parser = new FixedWidthParser(settings);
            List<String[]> parsedRows = parser.parseAll(inputReader);
            return parsedRows.stream().flatMap(Arrays::stream)
                    .reduce((firstMsg, secondMsg) -> firstMsg + secondMsg)
                    .map(String::trim)
                    .map(content -> content.replaceAll("null", " "))
                    .orElse("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getSplitByLength(String content) {
        System.out.println("content length : " + content.length());
        FixedWidthFields fieldLengths = new FixedWidthFields(50, 66, 74, 125, 140, 155, 157);
        FixedWidthParserSettings settings = new FixedWidthParserSettings(fieldLengths);
        FixedWidthParser parser = new FixedWidthParser(settings);
        return Arrays.asList(parser.parseLine(content)).stream().reduce((firstContent, secondContent) -> firstContent + " | " + secondContent).orElse("");
    }

    private String readTxtFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                stringBuilder.append(getSplitByLength(line) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private String readCsvFile(File file) {
        return "";
    }

    private void printContent(String content) {
        System.out.println("content :" + content);
    }
}

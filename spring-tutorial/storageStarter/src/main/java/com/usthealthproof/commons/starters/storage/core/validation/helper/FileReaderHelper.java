package com.usthealthproof.commons.starters.storage.core.validation.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;

@Slf4j
@Component
public class FileReaderHelper {

    public String processByFileFormat(File file) throws IOException {
        String content = null;
        String fileFormat = FileFormatIdentifier.getFileFormat(file);
        if (fileFormat.equalsIgnoreCase(".xls")) {
            content = readXlsFileAsString(file);
        } else if (fileFormat.equalsIgnoreCase(".csv")) {
            content = readCsvFileAsString(file);
        } else {
            content = readTxtFile(file);
        }
        return content;
    }

    public static String readXlsFileAsString(File xlsFile) throws IOException {
        String xlsFilePath = xlsFile.getPath();
        FileInputStream inputStream = new FileInputStream(xlsFilePath);
        Workbook workbook = null;
        if (xlsFilePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream); // For older XLS format
        } else if (xlsFilePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream); // For newer XLSX format
        }
        StringBuilder xlsData = null;
        if (workbook != null) {
            xlsData = new StringBuilder();
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        xlsData.append(cell.toString()).append("\t"); // Separated by tabs
                    }
                    xlsData.append("\n");
                }
            }
            System.out.println(xlsData.toString());
            workbook.close();
        } else {
            log.error("Unsupported file format.");
        }

        inputStream.close();
        log.info("<=================xls END================>");
        return xlsData.toString();
    }

    private String readCsvFileAsString(File file) {
        StringBuilder csvData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                csvData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("<=================CSV END================>");
        return csvData.toString();
    }

    public String readTxtFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
                log.info("line {}", lineNum++ + " : " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("<=================File END================>", stringBuilder.toString());

        return stringBuilder.toString();
    }

    /*public void fileReading(File file) throws IOException {
        if (FileValidator.isExist(file)) {
            if (FileValidator.isFile(file)) {
                if (FileValidator.canRead(file)) {
                    String content = FileValidator.readContent(file);
                    String content1 = String.valueOf(FileValidator.readContentAsByte(file));
                    String content2 = FileToStringReader.readFileAsString(file.getPath());

                    log.info("content : {}", content);
                    log.info("ContentAsByte : {}", content1);
                    log.info("readFileAsString : {}", content2);
                }
            } else if (FileValidator.isDirectory(file)) {

            } else {

            }

        } else {

        }
    }*/

}

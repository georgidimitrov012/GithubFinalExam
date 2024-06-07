package dev.Selenium.utils;

import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {

    public static Object[][] readFile(String fileName) throws IOException, CsvException {
        try(com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(new FileReader(fileName))) {
            List<String[]> csvData = csvReader.readAll();

            Object[][] csvDataObject = new Object[csvData.size()][];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }
}

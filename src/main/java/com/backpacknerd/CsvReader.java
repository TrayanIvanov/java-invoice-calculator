package com.backpacknerd;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CsvReader {
    public static List<String[]> read(String filename) throws IOException, CsvException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
        if (url == null) {
            throw new FileNotFoundException("asd");
        }

        FileReader file = new FileReader(url.getPath());
        CSVReader csvReader = new CSVReader(file);

        return csvReader.readAll();
    }
}

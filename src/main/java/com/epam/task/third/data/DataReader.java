package com.epam.task.third.data;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final static Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> readDataFromFile(String filename) throws DataException, PathException {
        List<String> lines = new ArrayList<>();

        BufferedReader bufferedReader = null;

        try {
            FileReader reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new PathException("file at the specified path doesn't exist", e);
        } catch (IOException e) {
            throw new DataException("file read error", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.warn(e.getMessage(), e);
            }
        }
        return lines;
    }
}

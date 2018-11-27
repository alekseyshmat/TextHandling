package com.epam.informationHandling.reader;

import com.epam.informationHandling.exception.ReadingFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReader {
    private static final String MESSAGE_FOR_EXCEPTION = "File is not found";
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public DataReader() {
    }

    public String readFile(Path path) throws ReadingFileException {
        StringBuilder dataFromFile = new StringBuilder();
        List<String> text;
        try {
            text = Files.readAllLines(path);
            for (String current : text) {
                if (dataFromFile.length() > 0) {
                    dataFromFile.append(String.format(" %s", current));
                } else {
                    dataFromFile.append(String.format("%s", current));
                }
            }
            LOGGER.info("File was read");
        } catch (IOException ex) {
            LOGGER.error("File was not found");
            throw new ReadingFileException(MESSAGE_FOR_EXCEPTION, ex);
        }
        return dataFromFile.toString();
    }
}

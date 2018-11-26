package com.epam.informationHandling.reader;

import com.epam.informationHandling.exception.ReadingFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanReader {

    private static final String MESSAGE_FOR_EXCEPTION = "File is not found";
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public String readFile(String path) throws ReadingFileException {
        StringBuilder dataFromFile = new StringBuilder();
        Scanner scanner = null;

        try {
            FileReader fileReader = new FileReader(path);
            scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                dataFromFile.append(scanner.next());
            }
            LOGGER.info("File was read");
        } catch (FileNotFoundException ex) {
            LOGGER.error("File is not found");
            throw new ReadingFileException(MESSAGE_FOR_EXCEPTION, ex);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return dataFromFile.toString();
    }
}

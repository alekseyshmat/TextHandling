package com.epam.informationHandling.exception;

public class ReadingFileException extends Exception {

    public ReadingFileException(String message) {
        super(message);
    }

    public ReadingFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadingFileException(Throwable cause) {
        super(cause);
    }
}

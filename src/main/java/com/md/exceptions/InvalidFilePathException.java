package com.md.exceptions;

public class InvalidFilePathException extends RuntimeException{

    public InvalidFilePathException(String message) {
        super(message);
    }

    public InvalidFilePathException(String message, Throwable cause) {
        super(message,cause);
    }
}

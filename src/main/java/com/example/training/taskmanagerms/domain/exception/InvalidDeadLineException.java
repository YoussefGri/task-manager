package com.example.training.taskmanagerms.domain.exception;

public class InvalidDeadLineException extends RuntimeException {
    public InvalidDeadLineException(String message) {
        super(message);
    }
}

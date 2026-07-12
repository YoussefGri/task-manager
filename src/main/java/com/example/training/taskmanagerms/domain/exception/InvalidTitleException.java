package com.example.training.taskmanagerms.domain.exception;

public class InvalidTitleException extends RuntimeException {
    public InvalidTitleException(String message) {
        super(message);
    }
}

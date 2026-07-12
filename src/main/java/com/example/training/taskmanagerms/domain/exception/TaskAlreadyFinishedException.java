package com.example.training.taskmanagerms.domain.exception;

public class TaskAlreadyFinishedException extends RuntimeException {
    public TaskAlreadyFinishedException(String message) {
        super(message);
    }
}

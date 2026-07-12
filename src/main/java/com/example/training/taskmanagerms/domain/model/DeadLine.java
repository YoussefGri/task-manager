package com.example.training.taskmanagerms.domain.model;

import com.example.training.taskmanagerms.domain.exception.InvalidDeadLineException;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DeadLine {

    private LocalDate deadline;

    public DeadLine(LocalDate deadline, LocalDate today) { //todo today est provisoire
        if (deadline == null || deadline.isBefore(today)) {
            throw new InvalidDeadLineException("Invalid deadline: " + deadline);
        }
        this.deadline = deadline;
    }

}

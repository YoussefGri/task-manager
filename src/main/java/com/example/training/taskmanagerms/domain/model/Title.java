package com.example.training.taskmanagerms.domain.model;

import com.example.training.taskmanagerms.domain.exception.InvalidTitleException;
import lombok.Getter;

@Getter
public class Title {

    private static final int MAX_LENGTH = 20;
    private String value;

    public Title(String value) {
        if (value == null || value.isEmpty() || value.length() > MAX_LENGTH) throw new InvalidTitleException("Mauvais format");
        this.value = value;
    }
}

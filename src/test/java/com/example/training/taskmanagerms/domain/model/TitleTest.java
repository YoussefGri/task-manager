package com.example.training.taskmanagerms.domain.model;

import com.example.training.taskmanagerms.domain.exception.InvalidTitleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TitleTest {

    @Test
    public void test_title_constructor() {
        Title title = new Title("test titre");
        assertEquals("test titre", title.getValue());
    }

    @Test
    public void test_title_never_null() {
        assertThrows(InvalidTitleException.class, () -> {
            new Title(null);
        });
    }

    @Test
    public void test_title_too_long() {
        assertThrows(InvalidTitleException.class, () -> {
            new Title("1234567891234567890000");
        });
    }
}

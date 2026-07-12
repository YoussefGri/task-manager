package com.example.training.taskmanagerms.domain.model;

import com.example.training.taskmanagerms.domain.exception.InvalidDeadLineException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

public class DeadLineTest {

    private static final LocalDate TODAY = LocalDate.of(2026, 1, 1);

    @Test
    public void test_dead_line_constructor() {
        assertEquals(
                TODAY.plusDays(1),
                new DeadLine(TODAY.plusDays(1), TODAY).getDeadline()
        );
    }

    @Test
    public void test_dead_line_wrong_date() {
        assertThrows(
                InvalidDeadLineException.class,
                () ->
                new DeadLine(TODAY.minusDays(1), LocalDate.now()).getDeadline()
        );
    }
}

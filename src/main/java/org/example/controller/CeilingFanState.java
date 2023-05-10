package org.example;

import java.time.LocalDate;

public interface CeilingFanState {
    void toggleDirection();
    void speedUp();
    boolean isOffForHoliday(LocalDate date);
}

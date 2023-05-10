package org.example.controller;

import java.time.LocalDate;

// Ceiling Fan core function skeleton
public interface CeilingFanState {
    void toggleDirection();
    void speedUp();
    boolean isOffForHoliday(LocalDate date);
}

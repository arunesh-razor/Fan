package org.example;

import java.time.LocalDate;
import java.util.Calendar;

public class CeilingFanController implements CeilingFanState{
    private static CeilingFanController instance = null;
    private CeilingFanSpeed currentSpeed;
    private LocalDate today;
    private Direction fanDirection;

    // Private constructor to enforce singleton pattern
    private CeilingFanController() {
        currentSpeed = CeilingFanSpeed.OFF;
        fanDirection = Direction.FORWARD;
    }

    // Public static method to get the singleton instance
    public static CeilingFanController getInstance() {
        if (instance == null) {
            instance = new CeilingFanController();
            instance.today = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        }
        return instance;
    }

    // Public method to set the state of the ceiling fan
    public void setDate(LocalDate date) {
        instance.today = date;
    }

    // Public method to set the state of the ceiling fan
    @Override
    public void speedUp() {
        if (!isOffForHoliday(instance.today)) {
            if (currentSpeed == CeilingFanSpeed.HIGH_SPEED) {
                currentSpeed = CeilingFanSpeed.OFF;
            } else if (currentSpeed == CeilingFanSpeed.MEDIUM_SPEED) {
                currentSpeed = CeilingFanSpeed.HIGH_SPEED;
            } else if (currentSpeed == CeilingFanSpeed.LOW_SPEED) {
                currentSpeed = CeilingFanSpeed.MEDIUM_SPEED;
            } else if (currentSpeed == CeilingFanSpeed.OFF) {
                currentSpeed = CeilingFanSpeed.LOW_SPEED;
            }
        } else {
            reset();
        }
    }

    // Public method to get the current speed setting of the ceiling fan
    public int getCurrentSpeed() {
        return currentSpeed.getValue();
    }

    // Public method to toggle the direction of the ceiling fan
    @Override
    public void toggleDirection() {
        if (!isOffForHoliday(instance.today)) {
            fanDirection = fanDirection == Direction.FORWARD ? Direction.BACKWARD : Direction.FORWARD;
        }
    }

    public Direction getCurrentDirection() {
        return fanDirection;
    }

    // Public method to check if the ceiling fan should be off based on the date
    @Override
    public boolean isOffForHoliday(LocalDate date) {
        return date.getMonthValue() == 12 && date.getDayOfMonth() == 25;
    }

    public void reset() {
        currentSpeed = CeilingFanSpeed.OFF;
        fanDirection = Direction.FORWARD;
    }
}

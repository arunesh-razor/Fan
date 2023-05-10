package org.example.constant;

// Ceiling Fan Speed setting
public enum CeilingFanSpeed {
    HIGH_SPEED(3),
    MEDIUM_SPEED(2),
    LOW_SPEED(1),
    OFF(0);

    private int value;

    private CeilingFanSpeed(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of the ceiling fan controller
        CeilingFanController controller = CeilingFanController.getInstance();

        // Pull the cords to change the state of the ceiling fan
        controller.setState(LowSpeedState.getInstance());
        controller.toggleDirection();
        controller.setState(MediumSpeedState.getInstance());
        controller.toggleDirection();
        controller.setState(HighSpeedState.getInstance());
        controller.setState(OffState.getInstance());
        controller.setState(HighSpeedState.getInstance());

        // Check the current speed and direction of the ceiling fan
        System.out.println("Current speed: " + controller.getCurrentSpeed());
        System.out.println("Direction clockwise? " + controller.getCurrentDirection());

        // Check if the ceiling fan should be off for the holiday
        LocalDate holidayDate = LocalDate.of(2023, 12, 25);
        if (controller.isOffForHoliday(holidayDate)) {
            controller.setState(OffState.getInstance());
        }
    }
}
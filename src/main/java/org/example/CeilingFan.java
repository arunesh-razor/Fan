package org.example;

import org.example.controller.CeilingFanController;

import java.time.LocalDate;

public class CeilingFan {
    public static void main(String[] args) {
        // Get the singleton instance of the ceiling fan controller
        CeilingFanController controller = CeilingFanController.getInstance();

        // Pull the cords to change the state of the ceiling fan
        controller.speedUp();
        controller.toggleDirection();
        controller.speedUp();
        controller.toggleDirection();
        controller.speedUp();
        controller.speedUp();
        controller.speedUp();
        controller.toggleDirection();

        // Check the current speed and direction of the ceiling fan
        System.out.println("Current speed: " + controller.getCurrentSpeed());
        System.out.println("Direction clockwise? " + controller.getCurrentDirection());

        // Setting date to holiday
        LocalDate holidayDate = LocalDate.of(2023, 12, 25);
        controller.setDate(holidayDate);
        controller.speedUp();

        // Check the current speed and direction of the ceiling fan
        System.out.println("Current speed: " + controller.getCurrentSpeed());
        System.out.println("Direction clockwise? " + controller.getCurrentDirection());
    }
}

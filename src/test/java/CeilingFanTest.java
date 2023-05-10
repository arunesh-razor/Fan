import org.example.constant.Direction;
import org.example.controller.CeilingFanController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeilingFanTest {

    private CeilingFanController controller;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        controller = CeilingFanController.getInstance();
    }

    @Test
    void testSpeedUp() {
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());
        assertEquals(0, controller.getCurrentSpeed());

        controller.speedUp();
        assertEquals(1, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(2, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(3, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());
    }

    @Test
    void testReverseSpeedUp() {
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());
        assertEquals(0, controller.getCurrentSpeed());

        controller.toggleDirection();
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());
        assertEquals(0, controller.getCurrentSpeed());

        controller.speedUp();
        assertEquals(1, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(2, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(3, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());
    }

    @Test
    void testReverseSpeedupDirection() {
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.toggleDirection();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(1, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.toggleDirection();
        assertEquals(1, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(2, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.toggleDirection();
        assertEquals(2, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(3, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());

        controller.toggleDirection();
        assertEquals(3, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.toggleDirection();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.BACKWARD, controller.getCurrentDirection());
    }

    @Test
    void testHolidaySetup() {
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(1, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        LocalDate holidayDate = LocalDate.of(2023, 12, 25);
        controller.setDate(holidayDate);
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.toggleDirection();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());

        controller.speedUp();
        assertEquals(0, controller.getCurrentSpeed());
        assertEquals(Direction.FORWARD, controller.getCurrentDirection());
    }
}



package interview.com.ssctech.toy.robot.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovementServiceTest {
  private MovementService movementService;

  @BeforeEach
  void setup() {
    movementService = new MovementService();
  }

  @Test
  void testInitial() {
    assertEquals(0, movementService.getXPos());
    assertEquals(0, movementService.getYPos());
    assertEquals(null, movementService.getFacing());
  }

  @Test
  void testReportWhenNonPlace() {
    assertEquals("Output: 0,0,null", movementService.report());
  }

  @Test
  void testReport_ExpectedZeroZeroSouth() {
    movementService.place(0, 0, "SOUTH");
    assertEquals("Output: 0,0,SOUTH", movementService.report());
  }
}

package interview.com.ssctech.toy.robot.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  void testFacingInvalid() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      movementService.place(0, 0, "FACING");
    });

    assertEquals("Invalid facing: FACING", ex.getMessage());
  }

  @Test
  void testPlace_ExpectXZeroYZeroFNorth() {
    movementService.place(0, 0, "NORTH");

    assertEquals(0, movementService.getXPos());
    assertEquals(0, movementService.getYPos());
    assertEquals(Direction.NORTH, movementService.getFacing());
  }

  @Test
  void testPlaceWhenOneOfAxisPlaceExceedMinUnit_ExpectZeroThreeZeroFNorth2() {
    movementService.place(-10, 1, "NORTH");

    assertEquals(0, movementService.getXPos());
    assertEquals(0, movementService.getYPos());
    assertEquals(Direction.NORTH, movementService.getFacing());
  }

  @Test
  void testPlaceWhenOneOfAxisPlaceExceedMaxUnit_ExpectZeroThreeZeroFNorth2() {
    movementService.place(0, 10, "NORTH");

    assertEquals(0, movementService.getXPos());
    assertEquals(0, movementService.getYPos());
    assertEquals(Direction.NORTH, movementService.getFacing());
  }


  @Test
  void testMoveWhenNonPlace() {
    Exception ex = assertThrows(NullPointerException.class, () -> {
      movementService.move();
    });

    assertEquals("Place facing before move", ex.getMessage());
  }

  @Test
  void testMove_ExpectedXZeroYOneFNorth() {
    movementService.place(0, 0, "NORTH");
    movementService.move();

    assertEquals(0, movementService.getXPos());
    assertEquals(1, movementService.getYPos());
    assertEquals(Direction.NORTH, movementService.getFacing());
  }

  @Test
  void testMoveCannotOverBorder_ExpectedXZeroYFourFNorth() {
    movementService.place(0, 4, "NORTH");
    movementService.move();

    assertEquals(0, movementService.getXPos());
    assertEquals(4, movementService.getYPos());
    assertEquals(Direction.NORTH, movementService.getFacing());
  }


  @Test
  void testLeftWhenNonPlace() {
    Exception ex = assertThrows(NullPointerException.class, () -> {
      movementService.left();
    });

    assertEquals("Place facing before turn left", ex.getMessage());
  }

  @Test
  void testLeft_ExpectedFacingWest() {
    movementService.place(0, 0, "NORTH");
    movementService.left();
    assertEquals(Direction.WEST, movementService.getFacing());
  }

  @Test
  void testRightWhenNonPlace() {
    Exception ex = assertThrows(NullPointerException.class, () -> {
      movementService.right();
    });

    assertEquals("Place facing before turn right", ex.getMessage());
  }

  @Test
  void testLeft_ExpectedFacingEast() {
    movementService.place(0, 0, "NORTH");
    movementService.right();
    assertEquals(Direction.EAST, movementService.getFacing());
  }

  @Test
  void testLeftAndRight_ExpectedFacingStand() {
    movementService.place(0, 0, "NORTH");
    movementService.left();
    movementService.right();
    assertEquals(Direction.NORTH, movementService.getFacing());
  }

  @Test
  void testRightAndLeft_ExpectedFacingStand() {
    movementService.place(0, 0, "EAST");
    movementService.left();
    movementService.right();
    assertEquals(Direction.EAST, movementService.getFacing());
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

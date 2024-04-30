package interview.com.ssctech.toy.robot.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class MovementControllerTest {

  @InjectMocks 
  private MovementController movementController;

  @Test
  void testFileInput() {
    ReflectionTestUtils.setField(movementController, "fileInput", "src/main/resources/static/file.txt");
    assertEquals("src/main/resources/static/file.txt", movementController.getFileInput());
  }

  @Test
  void testExecuteCommand() {
    MovementService movementService = new MovementService();

    movementController.executeCommand("PLACE 1,2,EAST", movementService);
    movementController.executeCommand("MOVE", movementService);
    movementController.executeCommand("MOVE", movementService);
    movementController.executeCommand("LEFT", movementService);
    movementController.executeCommand("MOVE", movementService);
    movementController.executeCommand("RIGHT", movementService);
    movementController.executeCommand("MOVE", movementService);
    String result = movementController.executeCommand("REPORT", movementService);

    assertEquals("Output: 4,3,EAST", result);
  }

}

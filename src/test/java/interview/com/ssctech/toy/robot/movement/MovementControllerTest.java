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

    movementController.executeCommand(new String[]{"PLACE 1,2,EAST"}, movementService);
    movementController.executeCommand(new String[]{"MOVE"}, movementService);
    movementController.executeCommand(new String[]{"MOVE"}, movementService);
    movementController.executeCommand(new String[]{"LEFT"}, movementService);
    movementController.executeCommand(new String[]{"MOVE"}, movementService);
    String result = movementController.executeCommand(new String[]{"REPORT"}, movementService);

    assertEquals(null, result);
  }

}

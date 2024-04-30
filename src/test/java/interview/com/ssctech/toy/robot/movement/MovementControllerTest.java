package interview.com.ssctech.toy.robot.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class MovementControllerTest {
  @InjectMocks
  private MovementController movementController;

  @Test
  void testFileInput() {
    ReflectionTestUtils.setField(movementController, "fileInput", "file");
    assertEquals("file", movementController.getFileInput());
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

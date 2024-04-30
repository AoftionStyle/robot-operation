package interview.com.ssctech.toy.robot.movement;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import lombok.Getter;

@Controller
public class MovementController implements CommandLineRunner {

  @Getter
  @Value("${app.file.input}")
  private String fileInput;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Movement CommandController");
    // read file
    System.out.println("fileInput: " + fileInput);
    Path filePath = new File(fileInput).toPath();

    // open-close file with try-resource
    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(Files.newInputStream(filePath), StandardCharsets.UTF_8))) {
      String line;
      MovementService movementService = null;
  
      // open loop read line
      while ((line = br.readLine()) != null) {
        System.out.println(line);
        String[] commands = line.split(" ");
        if ("PLACE".equals(commands[0])){
          // new instance then go through command
          movementService = new MovementService();
        }
        executeCommand(commands, movementService);
        if ("REPORT".equals(commands[0])) {
          // clean instance and waiting for 'PLACE' if not command can not execute 
          movementService = null;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected String executeCommand(String[] commands, MovementService movementService) {
    String result = null;
    switch (commands[0]) {
      case "PLACE":
        String[] placeInfo = commands[1].split(",");
        movementService.place(Integer.valueOf(placeInfo[0]), Integer.valueOf(placeInfo[1]), placeInfo[2]);
        break;
      case "MOVE":
        movementService.move();
        break;
      case "LEFT":
        movementService.left();
        break;
      case "RIGHT":
        movementService.right();
        break;
      case "REPORT":
        result = movementService.report();
        break;
      default:
        System.out.println("-----------------------");
        break;
    }
    return result;
  }

}

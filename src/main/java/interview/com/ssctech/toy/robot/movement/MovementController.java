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

      // open loop read line
      MovementService movementService = null;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
        if ("PLACE".equals(line.split(" ")[0])){
          movementService = new MovementService();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

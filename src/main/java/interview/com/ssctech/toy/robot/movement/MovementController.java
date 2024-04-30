package interview.com.ssctech.toy.robot.movement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class MovementController implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Movement CommandController");
    //TODO
    // read file
    // open loop read line

    // if PLACE then place()
    // initial movementService every PLACE
    // if MOVE or LEFT or RIGHT then move() or left() or right()
    // If REPORT then report()
    // clear after report or might be not when new

    // close file
  }

}

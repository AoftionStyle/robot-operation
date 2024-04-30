package interview.com.ssctech.toy.robot.movement;

public interface Movement {
  void place(int x, int y, String f);
  void move();
  void left();
  void right();
  String report();
}

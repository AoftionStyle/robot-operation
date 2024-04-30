package interview.com.ssctech.toy.robot.movement;

public class MovementService implements Movement {
  // square table equal on X,Y axis with 5x5 unit 
  protected static final int MIN_POSITION = 0;
  protected static final int MAX_POSITION = 4;

  private int xPos;
  private int yPos;
  private Direction facing;

  public MovementService() {
    // initial origin (0,0)
    xPos = 0;
    yPos = 0;
  }

  @Override
  public void place(int x, int y, String f) {
    //TODO
  }

  @Override
  public void move() {
    //TODO
  }

  @Override
  public void left() {
    //TODO
  }

  @Override
  public void right() {
    //TODO
  }

  @Override
  public String report() {
    //TODO
    return null;
  }
  
}

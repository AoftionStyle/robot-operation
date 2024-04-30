package interview.com.ssctech.toy.robot.movement;

import lombok.Getter;

public class MovementService implements Movement {
  // square table equal on X,Y axis with 5x5 unit 
  protected static final int MIN_POSITION = 0;
  protected static final int MAX_POSITION = 4;

  @Getter
  private int xPos;
  @Getter
  private int yPos;
  @Getter
  private Direction facing;

  public MovementService() {
    // initial origin (0,0)
    xPos = 0;
    yPos = 0;
  }

  protected boolean verifyPosition(int position) {
    return position >= MIN_POSITION && position <= MAX_POSITION ? true : false;
  }

  @Override
  public void place(int x, int y, String f) {
    if (verifyPosition(x) && verifyPosition(y)) {
      this.xPos = x;
      this.yPos = y;    
    }
    try {
      this.facing = Direction.valueOf(f);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid facing: " + f);
    }
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
    // Output: x,y,f
    String textReport = "Output: " + this.xPos + "," + this.yPos + "," + this.facing;
    System.out.println(textReport);
    return textReport;
  }
  
}

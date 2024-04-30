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
    if (this.facing == null) throw new NullPointerException("Place facing before move");
    
    switch (this.facing) {
      case NORTH:
        this.yPos = verifyPosition(this.yPos + 1) ? this.yPos + 1 : this.yPos;
        break;
      case SOUTH:
        this.yPos = verifyPosition(this.yPos - 1) ? this.yPos - 1 : this.yPos;
        break;
      case EAST:
        this.xPos = verifyPosition(this.xPos + 1) ? this.xPos + 1 : this.xPos;
        break;
      case WEST:
        this.xPos = verifyPosition(this.xPos - 1) ? this.xPos - 1 : this.xPos;
        break;
    }
  }

  @Override
  public void left() {
    if (this.facing == null) throw new NullPointerException("Place facing before turn left");

    switch (this.facing) {
      case NORTH:
        this.facing = Direction.WEST;
        break;
      case WEST:
        this.facing = Direction.SOUTH;
        break;
      case SOUTH:
        this.facing = Direction.EAST;
        break;
      case EAST:
        this.facing = Direction.NORTH;
        break;
    }
  }

  @Override
  public void right() {
    if (this.facing == null) throw new NullPointerException("Place facing before turn right");

    switch (this.facing) {
      case NORTH:
        this.facing = Direction.EAST;
        break;
      case EAST:
        this.facing = Direction.SOUTH;
        break;
      case SOUTH:
        this.facing = Direction.WEST;
        break;
      case WEST:
        this.facing = Direction.NORTH;
        break;
    }
  }

  @Override
  public String report() {
    // Output: x,y,f
    String textReport = "Output: " + this.xPos + "," + this.yPos + "," + this.facing;
    System.out.println(textReport);
    return textReport;
  }
  
}

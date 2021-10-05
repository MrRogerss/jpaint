package model.Picture;

/**
 * This class stores the mouse coordinates received from MouseHandler. It has two
 * fields for X and Y and methods to get each of them.
 */

public class Point {

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }




}

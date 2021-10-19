package model.interfaces;

import java.awt.Graphics;
import model.Picture.Point;

/**
 *  This class receives information from the ShapeFactory and draws the requested shape. In addition,
 *  it normalizes the mouse coordinates.
 *
 */

public interface IShape {

  void draw(Graphics g);

  Point getStart();
  Point getEnd();

  void addX(int x);
  void addY(int y);
  void subtractX(int x);
  void subtractY(int y);


}

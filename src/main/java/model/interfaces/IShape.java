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


}

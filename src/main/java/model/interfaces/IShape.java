package model.interfaces;

import java.awt.Graphics;
import model.Picture.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

/**
 *  This class receives information from the ShapeFactory and draws the requested shape. In addition,
 *  it normalizes the mouse coordinates.
 *
 */

public interface IShape {

  void draw(Graphics g);

  Point getStart();
  Point getEnd();

  void drawOutline(Graphics g);
  ShapeType getType();
  ShapeColor getPrimaryColor();
  ShapeColor getSecondaryColor();
  ShapeShadingType getShading();

  void addX(int x);
  void addY(int y);
  void subtractX(int x);
  void subtractY(int y);


}

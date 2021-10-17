package model.interfaces;

import java.awt.Graphics;
import java.awt.Point;

/**
 *  This class receives information from the ShapeFactory and draws the requested shape. In addition,
 *  it normalizes the mouse coordinates.
 *
 */

public interface IShape {

  void draw(Graphics g);

  model.Picture.Point normalizedPointStart(model.Picture.Point start, model.Picture.Point end);
  model.Picture.Point normalizedPointEnd(model.Picture.Point start, model.Picture.Point end);



}

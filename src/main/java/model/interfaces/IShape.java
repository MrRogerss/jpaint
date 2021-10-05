package model.interfaces;

import java.awt.Graphics;
import java.awt.Point;

/**
 *  This class receives information from CreateShapeCommand and draws a rectangle. In addition,
 *  this class normalizes the coordinates received from the Point Class.
 *
 */

public interface IShape {

  void draw(Graphics g);

  model.Picture.Point normalizedPointStart(model.Picture.Point start, model.Picture.Point end);
  model.Picture.Point normalizedPointEnd(model.Picture.Point start, model.Picture.Point end);



}

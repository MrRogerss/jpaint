package model.interfaces;

import java.awt.Graphics;
import java.awt.Point;


public interface IShape {

  void draw(Graphics g);

  model.Picture.Point normalizedPointStart(model.Picture.Point start, model.Picture.Point end);
  model.Picture.Point normalizedPointEnd(model.Picture.Point start, model.Picture.Point end);



}

package model;

import java.awt.Graphics;
import model.Picture.Point;
import model.interfaces.IShape;

public class Shape implements IShape {

  Point start;
  Point end;
  ShapeColor color;

  public Shape(Point start, Point end, ShapeColor color)
  {
      this.start = start;
      this.end = end;
      this.color = color;
  }


  @Override
  public void draw(Graphics g) {




  }
}

package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.Picture.Point;
import model.interfaces.IShape;
import model.Picture.NormalizePoints;

/**
 * @see model.interfaces.IShape
 */

public class Rectangle implements IShape {

  NormalizePoints normalize;
  Point start;
  Point end;
  ShapeColor color;

  public Rectangle(Point start, Point end, ShapeColor color)
  {
      normalize = new NormalizePoints(start, end);
      this.start = normalize.normalizedPointStart(start,end);
      this.end = normalize.normalizedPointEnd(start,end);
      this.color = color;
  }


  @Override
  public void draw(Graphics g) {

    Graphics2D graphics2D = (Graphics2D) g;

    graphics2D.setStroke(new BasicStroke(5));
    graphics2D.setColor(color.value);
    graphics2D.fillRect(start.getX(), start.getY(), (end.getX())- start.getX(),(end.getY())- start.getY());


  }

  @Override
  public Point getStart() {
    return start;
  }

  @Override
  public Point getEnd() {
    return end;
  }

  @Override
  public void addX(int x) {
    start.setX(start.getX() + x );
    end.setX(end.getX() + x);
  }

  @Override
  public void addY(int y) {
    start.setY(start.getY() + y );
    end.setY(end.getY() + y);
  }

  @Override
  public void subtractX(int x) {
    start.setX(start.getX() - x);
    end.setX(end.getX() - x);
  }

  @Override
  public void subtractY(int y) {
    start.setY(start.getY()-y);
    end.setY(end.getY() - y);
  }
}

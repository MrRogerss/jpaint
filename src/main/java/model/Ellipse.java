package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.Picture.Point;
import model.interfaces.IShape;
import model.Picture.NormalizePoints;

/**
 * @see model.interfaces.IShape
 */

public class Ellipse implements IShape {

  NormalizePoints normalize;
  Point start;
  Point end;
  ShapeColor color;

  public Ellipse(Point start, Point end, ShapeColor color){
    normalize = new NormalizePoints(start, end);
    this.start= normalize.normalizedPointStart(start, end);
    this.end = normalize.normalizedPointEnd(start, end);
    this.color = color;
  }

  @Override
  public void draw(Graphics g) {
    Graphics2D graphics2D = (Graphics2D) g;

    graphics2D.setStroke(new BasicStroke(5));
    graphics2D.setColor(color.value);
    graphics2D.fill(new Ellipse2D.Double(start.getX(), start.getY(),getWidth(),getHeight()));
  }


  private int getWidth(){
    return end.getX() - start.getX();
  }

  private int getHeight(){
    return end.getY()- start.getY();
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

package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.Picture.Point;
import model.interfaces.IShape;
import model.Picture.NormalizePoints;

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
}

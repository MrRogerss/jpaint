package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.Picture.Point;
import model.interfaces.IShape;

/**
 * @see model.interfaces.IShape
 */

public class Shape implements IShape {

  Point start;
  Point end;
  ShapeColor color;

  public Shape(Point start, Point end, ShapeColor color)
  {
      this.start = normalizedPointStart(start, end);
      this.end = normalizedPointEnd(start,end);
      this.color = color;
  }

  @Override
  public Point normalizedPointStart(Point start, Point end){

    int minX = Math.min(start.getX(), end.getX());
    int minY = Math.min(start.getY(),end.getY());

    return new Point(minX,minY);
  }

  public Point normalizedPointEnd(Point start, Point end){
    int maxX = Math.max(start.getX(), end.getX());
    int maxY = Math.max(start.getY(),end.getY());
    return new Point(maxX,maxY);
  }


  @Override
  public void draw(Graphics g) {

    Graphics2D graphics2D = (Graphics2D) g;

    graphics2D.setStroke(new BasicStroke(5));
    graphics2D.setColor(color.value);
    graphics2D.fillRect(start.getX(), start.getY(), (end.getX())- start.getX(),(end.getY())- start.getY());


  }



}

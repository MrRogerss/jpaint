package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.Picture.Point;
import model.decorators.BorderDecorator;
import model.interfaces.IShape;
import model.Picture.NormalizePoints;

/**
 * @see model.interfaces.IShape
 */

public class Rectangle implements IShape {

  NormalizePoints normalize;
  Point start;
  Point end;
  ShapeColor primaryColor;
  ShapeColor secondaryColor;
  ShapeShadingType shading;

  public Rectangle(Point start, Point end, ShapeColor primaryColor,ShapeColor secondaryColor, ShapeShadingType shading)
  {
      normalize = new NormalizePoints(start, end);
      this.start = normalize.normalizedPointStart(start,end);
      this.end = normalize.normalizedPointEnd(start,end);
      this.primaryColor = primaryColor;
      this.secondaryColor = secondaryColor;
      this.shading = shading;
  }

  public Rectangle(Rectangle original)
  {
    this.start = new Point(original.getStart().getX(),original.getStart().getY());
    this.end = new Point(original.getEnd().getX(),original.getEnd().getY());
    this.primaryColor = original.primaryColor;
    this.secondaryColor = original.secondaryColor;
    this.shading = original.shading;
  }


  @Override
  public void draw(Graphics g) {

    Graphics2D graphics2D = (Graphics2D) g;


    if(primaryColor != null)
    {
      graphics2D.setStroke(new BasicStroke(5));
      graphics2D.setColor(primaryColor.value);
      graphics2D.fillRect(start.getX(), start.getY(), (end.getX()) - start.getX(),
          (end.getY()) - start.getY());
    }

  }

  @Override
  public void drawOutline(Graphics g) {

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
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public ShapeColor getPrimaryColor() {
    return primaryColor;
  }

  @Override
  public ShapeColor getSecondaryColor() {
    return secondaryColor;
  }

  @Override
  public ShapeShadingType getShading() {
    return shading;
  }

  @Override
  public void addX(int x) {
    this.start.setX(start.getX() + x );
    this.end.setX(end.getX() + x);
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

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
  ShapeColor primaryColor;
  ShapeColor secondaryColor;
  ShapeShadingType shading;

  public Ellipse(Point start, Point end, ShapeColor primaryColor,ShapeColor secondaryColor, ShapeShadingType shading){
    normalize = new NormalizePoints(start, end);
    this.start= normalize.normalizedPointStart(start, end);
    this.end = normalize.normalizedPointEnd(start, end);
    this.primaryColor = primaryColor;
    this.secondaryColor = secondaryColor;
    this.shading = shading;
  }





  @Override
  public void draw(Graphics g) {
    Graphics2D graphics2D = (Graphics2D) g;

    graphics2D.setStroke(new BasicStroke(5));
    graphics2D.setColor(primaryColor.value);
    graphics2D.fillOval(start.getX(), start.getY(), getWidth(), getHeight());
  }

  @Override
  public void drawOutline(Graphics g) {

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
  public ShapeType getType() {
    return ShapeType.ELLIPSE;
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

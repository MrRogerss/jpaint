package model.decorators;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Picture.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

/**
 * This class is a decorator for Shapes. If the user selects a border in their shading type, this decorator
 * will be applied to their shape, giving the desired border treatment.
 */

public class BorderDecorator implements IShape {

  IShape shape;
  ShapeColor color;

  public BorderDecorator(IShape shape, ShapeColor color) {
    this.shape = shape;
    this.color = color;
  }

  @Override
  public void draw(Graphics g) {

    Graphics2D graphics2D = (Graphics2D) g;
    graphics2D.setStroke(new BasicStroke(5));
    graphics2D.setColor(color.value);

    if(shape.getType().equals(ShapeType.RECTANGLE)){
      graphics2D.drawRect(getStart().getX(), getStart().getY(), (getEnd().getX()) - getStart().getX(),(getEnd().getY())- getStart().getY());
    }

    else if(shape.getType().equals(ShapeType.TRIANGLE)){
      int[] x = new int[3];
      int[] y = new int[3];
      x[0] = getStart().getX();
      x[1] = getEnd().getX();
      x[2] = getStart().getX();
      y[0] = getStart().getY();
      y[1] = getEnd().getY();
      y[2] = getEnd().getY();
      graphics2D.drawPolygon(x,y,3);
    }
    else if (shape.getType().equals((ShapeType.ELLIPSE))){
      graphics2D.drawOval(getStart().getX(), getStart().getY(), (getEnd().getX()) - getStart().getX(),(getEnd().getY())- getStart().getY());
    }

    if(!shape.getShading().equals(ShapeShadingType.OUTLINE)) {

      shape.draw(g);
    }

  }

  @Override
  public Point getStart() {
    return shape.getStart();
  }

  @Override
  public Point getEnd() {
    return shape.getEnd();
  }

  @Override
  public void drawOutline(Graphics g) {
    shape.drawOutline(g);

  }

  @Override
  public ShapeType getType() {
    return shape.getType();
  }

  @Override
  public ShapeColor getPrimaryColor() {
    return shape.getPrimaryColor();
  }

  @Override
  public ShapeColor getSecondaryColor() {
    return shape.getSecondaryColor();
  }

  @Override
  public ShapeShadingType getShading() {
    return shape.getShading();
  }

  @Override
  public void addX(int x) {
    shape.addX(x);
  }

  @Override
  public void addY(int y) {
    shape.addY(y);

  }

  @Override
  public void subtractX(int x) {
    shape.subtractX(x);

  }

  @Override
  public void subtractY(int y) {
    shape.subtractY(y);

  }
}

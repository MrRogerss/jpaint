package model;


import model.Picture.Point;
import model.interfaces.IShape;

public class ShapeFactory {

  public IShape createShape(ShapeType type, ShapeColor color, Point start, Point end) {
    IShape newShape = null;
    if(type.equals(ShapeType.RECTANGLE)){
      newShape = new Rectangle(start, end, color);
    }

    return newShape;
  }

}

package model;


import model.Picture.Point;
import model.interfaces.IShape;

/**
 * This is a factory that creates shape commands based on the selected shape type.
 */

public class ShapeFactory {

  public IShape createShape(ShapeType type, ShapeColor primaryColor, ShapeColor secondaryColor, Point start, Point end) {
    IShape newShape = null;
    if(type.equals(ShapeType.RECTANGLE)){
      newShape = new Rectangle(start, end, primaryColor, secondaryColor);
    }

    if(type.equals(ShapeType.TRIANGLE)){
      newShape = new Triangle(start, end, primaryColor,secondaryColor);
    }

    if(type.equals(ShapeType.ELLIPSE)){
      newShape = new Ellipse(start, end, primaryColor,secondaryColor);
    }

    return newShape;
  }

}

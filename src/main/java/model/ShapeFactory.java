package model;


import model.Picture.Point;
import model.decorators.BorderDecorator;
import model.interfaces.IShape;

/**
 * This is a factory that creates shape commands based on the selected shape type.
 */

public class ShapeFactory {

  public IShape createShape(ShapeType type, ShapeColor primaryColor, ShapeColor secondaryColor, Point start, Point end, ShapeShadingType shading) {
    IShape newShape = null;
    if(shading.equals(ShapeShadingType.FILLED_IN)) {
      if(type.equals(ShapeType.RECTANGLE)) {
        newShape = new Rectangle(start, end, primaryColor, secondaryColor,shading);
      }
      if(type.equals(ShapeType.TRIANGLE)){
        newShape = new Triangle(start, end, primaryColor,secondaryColor,shading);
      }
      if(type.equals(ShapeType.ELLIPSE)){
        newShape = new Ellipse(start, end, primaryColor,secondaryColor,shading);
      }
    }
    if(shading.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
      if(type.equals(ShapeType.RECTANGLE)) {
        newShape = new BorderDecorator(new Rectangle(start, end, primaryColor, secondaryColor,shading), secondaryColor);
      }
      if(type.equals(ShapeType.TRIANGLE)){
        newShape = new BorderDecorator(new Triangle(start, end, primaryColor, secondaryColor,shading),secondaryColor);
      }
      if(type.equals(ShapeType.ELLIPSE)){
        newShape = new BorderDecorator(new Ellipse(start, end, primaryColor, secondaryColor,shading),secondaryColor);
      }
    }

    if(shading.equals(ShapeShadingType.OUTLINE)){
      if(type.equals(ShapeType.RECTANGLE)) {
        newShape = new BorderDecorator(new Rectangle(start, end, null, secondaryColor,shading), secondaryColor);
      }
      if(type.equals(ShapeType.TRIANGLE)){
        newShape = new BorderDecorator(new Triangle(start, end, null, secondaryColor,shading),secondaryColor);
      }
      if(type.equals(ShapeType.ELLIPSE)){
        newShape = new BorderDecorator(new Ellipse(start, end, null, secondaryColor,shading),secondaryColor);
      }
    }
    return newShape;
  }

}

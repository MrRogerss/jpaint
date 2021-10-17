package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Picture.Picture;
import model.Picture.Point;
import model.Rectangle;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeType;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

/**
 * This class gets the shape properties from UserChoices and creates a new
 * shape object. This object is added to the Picture class and the Command
 * History. It also supports redo and undo.
  */

public class CreateShapeCommand implements ICommand, Undoable {

  ShapeColor color;
  ShapeType type;
  Point start;
  Point end;
  Picture picture;
  IShape shape;


public CreateShapeCommand(UserChoices userChoices, Point start, Point end, Picture picture){
  this.color = userChoices.getActivePrimaryColor();
  this.type = userChoices.getActiveShapeType();
  this.start = start;
  this.end = end;
  this.picture = picture;
}

  @Override
  public void run() {
    shape = new ShapeFactory().createShape(type,color,start,end);
    this.picture.add(shape);
    CommandHistory.add(this);

  }

  @Override
  public void undo() {
    picture.remove(shape);
  }

  @Override
  public void redo() {
    picture.add(shape);

  }
}

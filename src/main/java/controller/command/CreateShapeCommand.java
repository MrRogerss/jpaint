package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Picture.Picture;
import model.Picture.Point;
import model.Shape;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

public class CreateShapeCommand implements ICommand, Undoable {

  UserChoices userChoices;
  Point start;
  Point end;
  Picture shapes;
  IShape shape;


public CreateShapeCommand(UserChoices userChoices, Point start, Point end, Picture shapes){
  this.userChoices = userChoices;
  this.start = start;
  this.end = end;
  this.shapes = shapes;
}

  @Override
  public void run() {
    System.out.println("running createShapeCommand");
    shape = new Shape(start, end, userChoices.getActivePrimaryColor());
    this.shapes.add(shape);
    CommandHistory.add(this);

  }

  @Override
  public void undo() {
    shapes.remove(shape);
  }

  @Override
  public void redo() {
    shapes.add(shape);

  }
}

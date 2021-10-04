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
  Picture picture;
  IShape shape;


public CreateShapeCommand(UserChoices userChoices, Point start, Point end, Picture picture){
  this.userChoices = userChoices;
  this.start = start;
  this.end = end;
  this.picture = picture;
}

  @Override
  public void run() {
    System.out.println("running createShapeCommand");
    shape = new Shape(start, end, userChoices.getActivePrimaryColor());
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

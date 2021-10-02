package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Picture.Point;
import model.interfaces.UserChoices;

public class CreateShapeCommand implements ICommand, Undoable {

  UserChoices userChoices;
  Point start;
  Point end;

public CreateShapeCommand(UserChoices userChoices, Point start, Point end){
  this.userChoices = userChoices;
  this.start = start;
  this.end = end;
}

  @Override
  public void run() {
    System.out.println("running");
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}

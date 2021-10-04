package controller.command;

import controller.interfaces.ICommand;
import model.Picture.Picture;
import model.Picture.Point;
import model.interfaces.UserChoices;


public class CommandController {

  private UserChoices userChoices;
  private Picture shapes;

  public CommandController(UserChoices userChoices, Picture shapes
  ) {
    this.userChoices = userChoices;
    this.shapes = shapes;

  }

  public void onDraw(Point start, Point end){
    ICommand command = new CreateShapeCommand(userChoices,start,end,shapes);
    command.run();

  }


}

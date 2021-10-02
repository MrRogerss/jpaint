package controller.command;

import controller.interfaces.ICommand;
import model.Picture.Point;
import model.interfaces.UserChoices;


public class CommandController {

  private UserChoices userChoices;

  public CommandController(UserChoices userChoices) {
    this.userChoices = userChoices;
  }

  public void onDraw(Point start, Point end){
    ICommand command = new CreateShapeCommand(userChoices,start,end);
    command.run();

  }


}

package controller.command;

import controller.interfaces.ICommand;
import model.MouseMode;
import model.Picture.Picture;
import model.Picture.Point;
import model.interfaces.UserChoices;

public class CommandFactory {

  Point start;
  Point end;
  Picture picture;
  CommandController commandController;

  public CommandFactory(Point start, Point end, CommandController commandController) {
    this.start = start;
    this.end = end;
    this.picture = picture;
    this.commandController = commandController;
  }

  public void command(CommandController commandController){

    if(commandController.getMouseMode().equals(MouseMode.DRAW)){
      commandController.onDraw(start,end);
    }
    if(commandController.getMouseMode().equals(MouseMode.SELECT)){
      commandController.onSelect(start,end);
    }
  }

}

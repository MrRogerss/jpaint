package controller.command;

import controller.interfaces.ICommand;
import model.Picture.Picture;
import model.Picture.Point;
import model.interfaces.UserChoices;

/**
 * This class is responsible for passing along the start and end mouse
 * coordinates to the CreateShapeCommand class, as well as passing
 * on the userChoices and Picture container.
 */

public class CommandController {

  private UserChoices userChoices;
  private Picture picture;

  public CommandController(UserChoices userChoices, Picture shapes
  ) {
    this.userChoices = userChoices;
    this.picture = shapes;

  }

  public void onDraw(Point start, Point end){
    ICommand command = new CreateShapeCommand(userChoices,start,end,picture);
    command.run();

  }


}

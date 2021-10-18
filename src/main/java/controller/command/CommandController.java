package controller.command;

import controller.interfaces.ICommand;
import model.MouseMode;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.interfaces.UserChoices;

/**
 * This class is responsible for passing along the start and end mouse
 * coordinates to the CreateShapeCommand class, as well as passing
 * on the userChoices and Picture container.
 */

public class CommandController {

  private UserChoices userChoices;
  private Picture picture;
  private SelectList selectList;

  public CommandController(UserChoices userChoices, Picture shapes, SelectList selectList) {
    this.userChoices = userChoices;
    this.picture = shapes;
    this.selectList = selectList;

  }

  public void onDraw(Point start, Point end){
    ICommand command = new CreateShapeCommand(userChoices,start,end,picture);
    command.run();
  }

  public void onSelect(Point start, Point end){
    ICommand select = new SelectCommand(start, end, picture,selectList);
    select.run();
  }

  public void onMove(Point start, Point end){

  }

  public MouseMode getMouseMode(){
    return userChoices.getActiveMouseMode();
  }


}

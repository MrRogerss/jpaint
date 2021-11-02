package controller.command;

import controller.interfaces.ICommand;
import model.MouseMode;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

/**
 * This class is responsible for passing along the start and end mouse
 * coordinates to the CreateShapeCommand class, as well as passing
 * on the userChoices and Picture container.
 */

public class CommandController {

  private UserChoices userChoices;
  private Picture picture;
  private SelectList selectList;
  private final PaintCanvas canvas;

  public CommandController(UserChoices userChoices, Picture shapes, SelectList selectList, PaintCanvas canvas) {
    this.canvas = canvas;
    this.userChoices = userChoices;
    this.picture = shapes;
    this.selectList = selectList;

  }

  public void onDraw(Point start, Point end){
    ICommand command = new CreateShapeCommand(userChoices,start,end,picture);
    command.run();
    canvas.repaint();
  }

  public void onSelect(Point start, Point end){
    ICommand select = new SelectCommand(start, end, picture,selectList);
    select.run();
    canvas.repaint();
  }

  public void onMove(Point start, Point end){
    canvas.repaint();
    ICommand move = new MoveCommand(start,end,selectList,picture);
    move.run();
    canvas.repaint();
  }

  public void onCopy(){
    ICommand copy = new CopyCommand(selectList,picture);
    copy.run();
  }

  public void onPaste(){
    canvas.repaint();
    ICommand paste = new PasteCommand(picture);
    paste.run();
    canvas.repaint();
  }

  public void onUndo() {
    CommandHistory.undo();
    canvas.repaint();
  }

  public void onRedo() {
    CommandHistory.redo();
    canvas.repaint();
  }

  public MouseMode getMouseMode(){
    return userChoices.getActiveMouseMode();
  }


}

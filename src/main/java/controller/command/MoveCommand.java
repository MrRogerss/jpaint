package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Picture.NormalizePoints;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;

public class MoveCommand implements ICommand, Undoable {

NormalizePoints normalize;
Point moveStart;
Point moveEnd;
SelectList selectList;
Picture picture;

  public MoveCommand(Point moveStart, Point moveEnd, SelectList selectList, Picture picture) {
    normalize = new NormalizePoints(moveStart,moveEnd);
    this.moveStart = normalize.normalizedPointStart(moveStart,moveEnd);
    this.moveEnd = normalize.normalizedPointEnd(moveStart,moveEnd);
    this.selectList = selectList;
    this.picture = picture;
  }

  @Override
  public void run() {

    int dx = moveEnd.getX() - moveStart.getX();
    int dy = moveEnd.getY() - moveEnd.getY();

  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}

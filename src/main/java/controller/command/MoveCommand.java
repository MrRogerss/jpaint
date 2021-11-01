package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Picture.NormalizePoints;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.interfaces.IShape;


/**
    This class takes shapes from the selected List and moves them to the users desired
    location on the canvas. Has support for undo and redo.

 */
public class MoveCommand implements ICommand, Undoable {
private ArrayList<IShape> movedShapes = new ArrayList<>();
NormalizePoints normalize;
Point moveStart;
Point moveEnd;
SelectList selectList;
Picture picture;
int dx;
int dy;

  public MoveCommand(Point moveStart, Point moveEnd, SelectList selectList, Picture picture) {
    normalize = new NormalizePoints(moveStart,moveEnd);
    this.moveStart = moveStart;
    this.moveEnd = moveEnd;
    this.selectList = selectList;
    this.picture = picture;
    dx = moveEnd.getX() - moveStart.getX();
    dy = moveEnd.getY() - moveStart.getY();
  }

  @Override
  public void run() {

    movedShapes.addAll(selectList.getSelect());

    for(IShape shape : movedShapes)
    {
      shape.addX(dx);
      shape.addY(dy);
    }
    CommandHistory.add(this);

  }

  @Override
  public void undo() {
    for(IShape shape : movedShapes)
    {
      shape.subtractX(dx);
      shape.subtractY(dy);
    }

  }

  @Override
  public void redo() {
    for(IShape shape : movedShapes)
    {
      shape.addX(dx);
      shape.addY(dy);
    }

  }
}

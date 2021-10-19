package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import model.Picture.NormalizePoints;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.interfaces.IShape;

public class MoveCommand implements ICommand, Undoable {

NormalizePoints normalize;
Point moveStart;
Point moveEnd;
SelectList selectList;
Picture picture;
IShape newShapeLocation;
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

    for(IShape shape : selectList.getSelect())
    {
      newShapeLocation = shape;
      newShapeLocation.addX(dx);
      newShapeLocation.addY(dy);
      selectList.remove(shape);
      picture.remove(shape);
      picture.add(newShapeLocation);
      selectList.add(newShapeLocation);
    }
    CommandHistory.add(this);

  }

  @Override
  public void undo() {
    for(IShape shape : selectList.getSelect())
    {
      newShapeLocation = shape;
      newShapeLocation.subtractX(dx);
      newShapeLocation.subtractY(dy);
      selectList.remove(shape);
      picture.remove(shape);
      picture.add(newShapeLocation);
      selectList.add(newShapeLocation);
    }

  }

  @Override
  public void redo() {
    for(IShape shape : selectList.getSelect())
    {
      newShapeLocation = shape;
      newShapeLocation.addX(dx);
      newShapeLocation.addY(dy);
      selectList.remove(shape);
      picture.remove(shape);
      picture.add(newShapeLocation);
      selectList.add(newShapeLocation);
    }

  }
}

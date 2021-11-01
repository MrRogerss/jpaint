package controller.command;

import controller.interfaces.ICommand;
import model.Ellipse;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.Rectangle;
import model.ShapeFactory;
import model.ShapeType;
import model.Triangle;
import model.interfaces.IShape;

public class CopyCommand implements ICommand{

  SelectList selectList;
  Picture picture;

  public CopyCommand(SelectList selectList, Picture picture) {
    this.selectList = selectList;
    this.picture = picture;
  }

  @Override
  public void run() {

    for(IShape shape: selectList.getSelect())
    {
      IShape newShape = new ShapeFactory().createShape(shape.getType(),shape.getPrimaryColor(),shape.getSecondaryColor(),
          new Point(shape.getStart().getX(),shape.getStart().getY()),new Point(shape.getEnd().getX(),shape.getEnd().getY()),
          shape.getShading());
      picture.addCopy(newShape);

    }
  }

}

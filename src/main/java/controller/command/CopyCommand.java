package controller.command;

import controller.interfaces.ICommand;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.ShapeFactory;
import model.interfaces.IShape;

/**
 * The CopyCommand takes the shapes from the users current selections in the selectedList
 * and creates deep copies of them. These copies are added to the Picture class' copiedList.
 */

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

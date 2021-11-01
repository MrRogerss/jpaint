package controller.command;

import controller.interfaces.ICommand;
import java.util.ArrayList;
import model.Ellipse;
import model.Picture.Picture;
import model.Picture.SelectList;
import model.Rectangle;
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
      IShape newShape;
      if (shape.getType().equals(ShapeType.RECTANGLE)) {
        newShape = new Rectangle((Rectangle) shape);
        picture.addCopy(newShape);
      }
      if(shape.getType().equals(ShapeType.TRIANGLE)){
        newShape = new Triangle((Triangle) shape);
        picture.addCopy(newShape);
      }
      if(shape.getType().equals(ShapeType.ELLIPSE)){
        newShape = new Ellipse((Ellipse) shape);
        picture.addCopy(newShape);
      }
    }
  }

}

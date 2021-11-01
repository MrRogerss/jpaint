package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Ellipse;
import model.Picture.Picture;
import model.Rectangle;
import model.ShapeType;
import model.Triangle;
import model.interfaces.IShape;

public class PasteCommand implements ICommand, Undoable {

  private final ArrayList<IShape> pasted = new ArrayList<>();
  Picture picture;
  IShape newShape;

  public PasteCommand(Picture picture) {
    this.picture = picture;
  }

  @Override
  public void run() {


    for(IShape shape: picture.getCopied())
    {

      if (shape.getType().equals(ShapeType.RECTANGLE)) {
        newShape = new Rectangle((Rectangle) shape);
        newShape.addX(30);
        newShape.addY(30);
        pasted.add(newShape);
      }
      if(shape.getType().equals(ShapeType.TRIANGLE)){
        newShape = new Triangle((Triangle) shape);
        newShape.addX(30);
        newShape.addY(30);
        pasted.add(newShape);
      }
      if(shape.getType().equals(ShapeType.ELLIPSE)){
        newShape = new Ellipse((Ellipse) shape);
        newShape.addX(30);
        newShape.addY(30);
        pasted.add(newShape);
      }
    }

    for(IShape shapes : pasted){
      picture.add(shapes);
    }
    CommandHistory.add(this);
  }

  @Override
  public void undo() {

    for(IShape newShape : pasted ){
      picture.remove(newShape);
    }
  }

  @Override
  public void redo() {
    for(IShape newShape : pasted ){
      picture.add(newShape);
    }

  }
}

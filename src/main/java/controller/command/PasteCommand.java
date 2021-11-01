package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Ellipse;
import model.Picture.Picture;
import model.Picture.Point;
import model.Rectangle;
import model.ShapeFactory;
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
      IShape newShape = new ShapeFactory().createShape(shape.getType(),shape.getPrimaryColor(),shape.getSecondaryColor(),
          new Point(shape.getStart().getX(),shape.getStart().getY()),new Point(shape.getEnd().getX(),shape.getEnd().getY()),
          shape.getShading());
      newShape.addX(30);
      newShape.addY(30);
      pasted.add(newShape);
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

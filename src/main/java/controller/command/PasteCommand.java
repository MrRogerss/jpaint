package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Picture.Picture;
import model.Picture.Point;
import model.ShapeFactory;

import model.interfaces.IShape;

/**
 * This class takes the deep copied shapes from the copiedList and pastes them
 * onto the canvas. The paste is offset slightly from the original shape so the
 * user can tell it was pasted. In addition, more deep copies are made and stored
 * in an ArrayList so Undoing and Redoing a paste is possible.
 */

public class PasteCommand implements ICommand, Undoable {

  private final ArrayList<IShape> pasted = new ArrayList<>();
  Picture picture;

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

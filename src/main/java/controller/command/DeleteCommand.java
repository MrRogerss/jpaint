package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Picture.Picture;
import model.Picture.SelectList;
import model.interfaces.IShape;

/**
 * Takes shapes from the selected shapes list and deletes them from the canvas.
 * This command also supports the undoing and redoing of shapes.
 */

public class DeleteCommand implements ICommand, Undoable {

  Picture picture;
  SelectList selectList;
  ArrayList <IShape> deleteShapes = new ArrayList<>();

  public DeleteCommand(Picture picture , SelectList selectList){
    this.picture = picture;
    this.selectList = selectList;
  }

  @Override
  public void run() {
    deleteShapes.addAll(selectList.getSelect());
    for(IShape shape :deleteShapes){
      picture.remove(shape);
      selectList.remove(shape);
    }
    CommandHistory.add(this);

  }

  @Override
  public void undo() {
    for(IShape shape : deleteShapes){
      picture.add(shape);
    }

  }

  @Override
  public void redo() {
    for(IShape shape : deleteShapes){
      picture.remove(shape);
    }

  }
}

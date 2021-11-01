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
 * Selects shapes and adds them to the select class.
 */

public class SelectCommand implements ICommand {
  NormalizePoints normalize;
  Point boundaryStart;
  Point boundaryEnd;
  Picture picture;
  SelectList selectList;
  int boundaryLeft;
  int boundaryRight;
  int boundaryTop;
  int boundaryBottom;

  public SelectCommand(Point boundaryStart, Point boundaryEnd, Picture picture,SelectList selectList)
  {
    normalize = new NormalizePoints(boundaryStart, boundaryEnd);
    this.boundaryStart = normalize.normalizedPointStart(boundaryStart,boundaryEnd);
    this.boundaryEnd = normalize.normalizedPointEnd(boundaryStart, boundaryEnd);
    this.picture = picture;
    this.selectList = selectList;
    boundaryLeft = this.boundaryStart.getX();
    boundaryRight = this.boundaryEnd.getX();
    boundaryTop = this.boundaryStart.getY();
    boundaryBottom = this.boundaryEnd.getY();
  }

  @Override
  public void run() {

    ArrayList<IShape> temp = new ArrayList<IShape>();
    boolean selectedOnce = false;

    for(IShape shape : picture.getPicture()){
      if(overlapSides(shape) && overlapTopandBottom(shape))
      {
        selectedOnce = true;
        temp.add(shape);
      }
    }
    if(selectedOnce == true){
      selectList.clearSelected();
      picture.clearCopied();
      for(IShape shape : temp ){
        System.out.println("Selected shape");
        selectList.add(shape);
      }
    }
  }

  public boolean overlapSides(IShape shape){
    int shapeLeft = shape.getStart().getX();
    int shapeRight = shape.getEnd().getX();

    return (boundaryRight > shapeLeft && boundaryRight < shapeRight) ||
        (shapeRight > boundaryLeft && shapeRight < boundaryRight);
  }

  public boolean overlapTopandBottom(IShape shape){
    int shapeTop = shape.getStart().getY();
    int shapeBottom = shape.getEnd().getY();

    return (boundaryBottom > shapeTop && boundaryBottom < shapeBottom) ||
        (shapeBottom > boundaryTop && shapeBottom < boundaryBottom);

  }
}

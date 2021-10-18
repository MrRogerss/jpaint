package controller.command;

import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.Picture.NormalizePoints;
import model.Picture.Picture;
import model.Picture.Point;
import model.Picture.SelectList;
import model.interfaces.IShape;

public class SelectCommand implements ICommand {

  NormalizePoints normalize;
  Point boundaryStart;
  Point boundaryEnd;
  Picture picture;
  SelectList selectList;

  public SelectCommand(Point boundaryStart, Point boundaryEnd, Picture picture,SelectList selectList)
  {
    normalize = new NormalizePoints(boundaryStart, boundaryEnd);
    this.boundaryStart = normalize.normalizedPointStart(boundaryStart,boundaryEnd);
    this.boundaryEnd = normalize.normalizedPointEnd(boundaryStart, boundaryEnd);
    this.picture = picture;
    this.selectList = selectList;
  }

  @Override
  public void run() {

    ArrayList<IShape> temp = new ArrayList<IShape>();
    boolean selectedOnce = false;

    for(IShape shape : picture.getPicture()){
      if(shape.getStart().getX() < boundaryStart.getX() && shape.getStart().getY() < boundaryStart.getY() &&
          shape.getEnd().getX() > boundaryStart.getX() && shape.getEnd().getY() > boundaryStart.getY())
      {
        selectedOnce = true;
        temp.add(shape);
      }
    }
    if(selectedOnce == true){
      selectList.clearSelected();
      for(IShape shape : temp ){
        System.out.println("Selected shape");
        selectList.add(shape);
      }
    }





  }
}
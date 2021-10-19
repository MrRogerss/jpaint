package model.Picture;

import java.util.ArrayList;
import model.interfaces.IShape;

public class SelectList {

  private ArrayList<IShape> select;
  private ArrayList<IShape> selectUndo;

  public SelectList(){
    select = new ArrayList<IShape>();
    selectUndo = new ArrayList<IShape>();
  }

  public void add(IShape shape){

    select.add((shape));
  }

  public void remove(IShape shape){

    select.remove(shape);
  }

  public void clearSelected(){
    select.clear();
  }

  public void addUndo (IShape shape){
    selectUndo.add(shape);
  }

  public void removeUndo(IShape shape){

    selectUndo.remove(shape);
  }

  public void clearSelectedUndo(){
    selectUndo.clear();
  }



  public ArrayList<IShape> getSelect(){
    return select;
  }

  public ArrayList<IShape> getSelectUndo(){
    return selectUndo;
  }



}

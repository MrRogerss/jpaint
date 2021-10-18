package model.Picture;

import java.util.ArrayList;
import model.interfaces.IShape;

public class SelectList {

  private ArrayList<IShape> select;

  public SelectList(){
    select = new ArrayList<IShape>();
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



  public ArrayList<IShape> getSelect(){
    return select;
  }

}

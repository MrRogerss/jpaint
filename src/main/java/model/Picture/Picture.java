package model.Picture;
import java.util.ArrayList;
import model.interfaces.IShape;

/**
 * Container that contains Shape objects to draw. It stores these shapes
 * in an ArrayList. It contains methods to add a shape,remove a shape, or
 * return the ArrayList.
 *
 */

public class Picture {

  private ArrayList<IShape> picture;

  public Picture(){
    picture = new ArrayList<IShape>();
  }

  public void add(IShape shape){
    picture.add((shape));
  }

  public void remove(IShape shape){

    picture.remove(shape);
  }

  public ArrayList<IShape> getPicture(){
    return picture;
  }

}

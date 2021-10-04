package model.Picture;
import java.lang.reflect.Array;
import java.util.ArrayList;
import model.interfaces.IShape;

/**
 * Container that contains Shape objects to draw. It stores these shapes
 * in an ArrayList.
 *
 */

public class Picture {

  private ArrayList<IShape> shapes;

  public Picture(){
    shapes = new ArrayList<IShape>();
  }

  public void add(IShape shape){
    shapes.add((shape));
  }

  public void remove(IShape shape){

    shapes.remove(shape);
  }

}

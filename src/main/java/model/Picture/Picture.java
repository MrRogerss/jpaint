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
  private ArrayList<IShape> copied;

  public Picture(){
    picture = new ArrayList<IShape>();
    copied = new ArrayList<>();
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

  public void addCopy(IShape shape){
    copied.add(shape);
  }

  public void removeCopy(IShape shape){
    copied.remove(shape);
  }

  public ArrayList<IShape> getCopied(){
    return copied;
  }

  public void clearCopied(){
    copied.clear();
  }





}

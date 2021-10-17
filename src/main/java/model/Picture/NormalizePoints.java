package model.Picture;

public class NormalizePoints {

  Point start;
  Point end;

  public NormalizePoints(Point start, Point end)
  {
    this.start = start;
    this.end = end;
  }

  public Point normalizedPointStart(Point start, Point end) {
    int minX = Math.min(start.getX(), end.getX());
    int minY = Math.min(start.getY(),end.getY());

    return new Point(minX,minY);  }

  public Point normalizedPointEnd(Point start, Point end) {
    int maxX = Math.max(start.getX(), end.getX());
    int maxY = Math.max(start.getY(),end.getY());
    return new Point(maxX,maxY);  }
}

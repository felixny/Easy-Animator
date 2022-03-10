package model.motion;


/**
 * A class that extends AbstractMotion.
 */
public class Move extends AbstractMove {
  private final double x1;
  private final double y1;
  private final double x2;
  private final double y2;

  /**
   * A constructor for move class.
   *
   * @param shapeId   the shape id
   * @param startTime the start time of change in position
   * @param endTime   the end time of change in position
   * @param x1        the starting x coordinate
   * @param y1        the starting y coordinate
   * @param x2        the ending x coordinate
   * @param y2        the ending y coordinate
   * @throws IllegalArgumentException if the movement isn't changed
   */
  public Move(String shapeId, int startTime, int endTime, double x1, double y1,
              double x2, double y2)
          throws IllegalArgumentException {
    super(shapeId, startTime, endTime);

    if ((x2 - x1 == 0 || x1 - x2 == 0) && (y2 - y1 == 0 || y1 - y2 == 0)) {
      throw new IllegalArgumentException("the movement isn't changed.");
    } else {

      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
    }
  }

  /**
   * String representation of the changes made.
   */
  @Override
  public String getStatus() {
    String getStatus;
    getStatus = String.format("Shape %s moves from (%s, %s) to (%s, %s) from time t =%d to t =%d",
            this.shapeId, this.x1, this.y1, this.x2, this.y2, startTime, endTime);
    return getStatus;
  }

  public double getX1() {
    return this.x1;
  }

  public double getX2() {
    return this.x2;
  }

  public double getY1() {
    return this.y1;
  }

  public double getY2() {
    return this.y2;
  }

  @Override
  public String getShapeId() {
    return shapeId;
  }

}

package model.motion;

/**
 * A class that extends AbstractMotion.
 */
public class ScaleShape extends AbstractMove {
  private double startW;
  private double startH;
  private double endW;
  private double endH;

  /**
   * Constructor that initializes all parameters of a class.
   *
   * @param shapeId   the id of shape
   * @param startTime the start time of change
   * @param endTime the end time of change
   * @param startW the start width
   * @param startH the start height
   * @param endW the end width
   * @param endH the end height
   */
  public ScaleShape(String shapeId, int startTime, int endTime,
                    double startW, double startH,
                    double endW, double endH) {
    super(shapeId,
            startTime,
            endTime);
    this.startW = startW;
    this.startH = startH;
    this.endW = endW;
    this.endH = endH;

  }

  /**
   * Method to get start width.
   *
   * @return start Width
   */
  public double getStartW() {
    return this.startW;
  }

  /**
   * Method to get start height.
   *
   * @return start height
   */
  public double getStartH() {
    return this.startH;
  }

  /**
   * Method to get start width.
   *
   * @return end width
   */
  public double getEndW() {
    return this.endW;
  }

  /**
   * Method to get end height.
   *
   * @return end height
   */
  public double getEndH() {
    return this.endH;
  }

  /**
   * String representation of the changes made.
   */
  @Override
  public String getStatus() {
    String getStatus;
    getStatus = String.format("Shape %s scales from Width: %s, Height: %s to Width: %s, Height: %s "
            + "from time t =%d to t =%d", this.shapeId, this.startW, this.startH,
            this.endW, this.endH,
            this.startTime, this.endTime);
    return getStatus;
  }


  
  @Override
  public String getShapeId() {
    return this.shapeId;
  }

}

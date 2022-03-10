package model.motion;

/**
 * Abstract class that implements Motion.
 */
public abstract class AbstractMove implements Motion {
  protected String shapeId;
  protected int startTime;
  protected int endTime;

  /**
   * Constructor that initializes all parameters of a class.
   *
   * @param shapeId the id of shape
   */
  public AbstractMove(String shapeId, int startTime, int endTime) {
    this.shapeId = shapeId;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Method that gets the start time.
   *
   * @return start time
   */
  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Method that gets the end time.
   *
   * @return end time
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Method that gets the shape id.
   *
   * @return shape id
   */
  @Override
  public String getStatus() {
    return this.shapeId;
  }
}

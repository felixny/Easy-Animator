package model.motion;

/**
 * Interface that represents a Motion interface. This is common to all the class represented
 * by subclass.
 */
public interface Motion {
  /**
   * Method that returns string of what the motion is doing.
   *
   * @return string
   */
  String getStatus();

  /**
   * Method that identifies the shape.
   *
   * @return string
   */
  String getShapeId();

  /**
   * Method that get the start time of a motion.
   *
   * @return string
   */
  int getStartTime();

  /**
   * Method that get the end time of a motion.
   *
   * @return end time
   */
  int getEndTime();

}
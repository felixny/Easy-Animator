package model.motion;

import java.awt.Color;

/**
 * A class that extends AbstractMotion.
 */
public class ChangeColor extends AbstractMove {
  private Color startColor;
  private Color targetColor;

  /**
   * Constructor that initializes all parameters of a class.
   *
   * @param shapeId   the id of shape
   * @param startTime the start time of change
   * @param endTime the end time of change
   * @param startColor starting color
   * @param targetColor target color
   * @throws IllegalArgumentException if the color component is negative
   */
  public ChangeColor(String shapeId, int startTime, int endTime,
                     Color startColor, Color targetColor) {
    super(shapeId, startTime, endTime);
    this.startColor = startColor;
    this.targetColor = targetColor;
  }


  /**
   * String representation of the changes made.
   */
  @Override
  public String getStatus() {
    String getStatus;
    getStatus = String.format("Shape %s changes color from %s to %s "
            + "from time t=%d to t=%d", this.shapeId, this.startColor,
            this.targetColor, this.startTime, this.endTime);
    return getStatus;
  }

  @Override
  public String getShapeId() {
    return this.shapeId;
  }
}

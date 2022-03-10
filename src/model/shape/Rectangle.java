package model.shape;

import java.awt.Color;

/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the shape.Shape interface
 */
public class Rectangle extends AbstractShape {

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions.
   *
   * @param id the string containing the id name of the shape object
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   * @param color  color of this rectangle
   */
  public Rectangle(String id, int x, int y,
                   int width, int height, Color color) {
    super(id, x, y, height, width, color);
  }

  @Override
  public String toString() {
    return String.format("%s rectangle %s with corner at (%d,%d), width %d and height %d",
            this.color, this.id, this.location.getX(),
            this.location.getY(), this.width, this.height);
  }

  @Override
  public String getID() {
    return null;
  }

  @Override
  public String getX() {
    return null;
  }

  @Override
  public String getY() {
    return null;
  }

  @Override
  public String getW() {
    return null;
  }

  @Override
  public String getH() {
    return null;
  }

  @Override
  public Integer getR() {
    return null;
  }

  @Override
  public Integer getG() {
    return null;
  }

  @Override
  public Integer getB() {
    return null;
  }

  @Override
  public String getStatus() {
    return null;
  }
}
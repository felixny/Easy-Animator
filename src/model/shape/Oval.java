package model.shape;

import java.awt.Color;

/**
 * This class represents an Oval object defined by width and height, and point signaling her central
 * location. It offers all the operations mandated by the Shape interface.
 */
public class Oval extends AbstractShape {

  /**
   * Constructs an Oval object with the given location of its centered location and height width
   * dimensions.
   *
   * @param id     the string containing the id name of the shape object
   * @param x      x coordinate of the center of this oval
   * @param y      y coordinate of the center of this oval
   * @param width  width of this oval
   * @param height height of this oval
   */
  public Oval(String id, int x, int y, int width, int height, Color color) {
    super(id, x, y, height, width, color);
  }

  @Override
  public String toString() {
    return String.format("%s oval %s with center at (%d,%d), radius %d and %d",
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
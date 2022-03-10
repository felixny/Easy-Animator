package model.shape;

/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x,y).
 */
public class Point2D {
  private int x;
  private int y;

  /**
   * Construct a 2d point with the given coordinates.
   *
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point
   */
  public int getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point
   */
  public int getY() {
    return y;
  }

  /**
   * Update the x-coordinate of this point.
   *
   * @param x x-coordinate to update this point
   */
  public void updateX(int x) {
    this.x = x;
  }

  /**
   * Update the y-coordinate of this point.
   *
   * @param y y-coordinate to update this point
   */
  public void updateY(int y) {
    this.y = y;
  }

  /**
   * Update the x-coordinate and y-coordinate of this point.
   *
   * @param x x-coordinate to update this point
   * @param y y-coordinate to update this point
   */
  public void updatePosition(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
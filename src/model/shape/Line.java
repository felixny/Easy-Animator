package model.shape;

import java.awt.Color;

/**
 * This class represents a line. This line is denoted with a start 2d point and an end 2d point,
 * both with Cartesian coordinates as (x,y).
 */
public class Line {
  protected Color color;
  protected Point2D startPoint;
  protected Point2D endPoint;
  protected String id;

  /**
   * Construct a line with specified 2d points with the given coordinates.
   *
   * @param id the string containing the id name of the shape object
   * @param startX the x-coordinate of the start point
   * @param startY the x-coordinate of the start point
   * @param endX the x-coordinate of the end point
   * @param endY the y-coordinate of the end point
   */
  public Line(String id, int startX, int startY, int endX, int endY, Color color) {
    this.id = id;
    this.startPoint = new Point2D(startX, startY);
    this.endPoint = new Point2D(endX, endY);
    this.color = color;
  }

  /**
   * Get the id name of this shape.
   *
   * @return the id name of this shape
   */
  public String getId() {
    return this.id;
  }

  /**
   * Return the start 2d point of this line.
   *
   * @return start 2d point of this line
   */
  public Point2D getStartPoint() {
    return startPoint;
  }

  /**
   * Return the end 2d point of this line.
   *
   * @return end 2d point of this line
   */
  public Point2D getEndPoint() {
    return endPoint;
  }

  /**
   * Return the color this line.
   *
   * @return the color of this line
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Update the coordinates of the start point of this line.
   *
   * @param x  x-coordinate to move start point
   * @param y  y-coordinate to move start point
   */
  public void moveStartPoint(int x, int y) {
    this.startPoint.updatePosition(x, y);
  }


  /**
   * Update the coordinates of the end point of this line.
   *
   * @param x  x-coordinate to move end point
   * @param y  y-coordinate to move end point
   */
  public void moveEndPoint(int x, int y) {
    this.endPoint.updatePosition(x, y);
  }


  /**
   * Update the coordinates of start and end 2d points.
   *
   * @param startX  x-coordinate to move start point
   * @param startY  y-coordinate to move start point
   * @param endX  x-coordinate to move end point
   * @param endY  y-coordinate to move end point
   */
  public void move(int startX, int startY, int endX, int endY) {
    this.startPoint.updatePosition(startX, startY);
    this.endPoint.updatePosition(endX, endY);
  }

  /**
   * Update the color of this line.
   *
   * @param color the color to be assigned to this line
   */
  public void changeColor(Color color) {
    this.color = color;
  }

}
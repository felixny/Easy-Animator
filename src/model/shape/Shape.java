package model.shape;

import java.awt.Color;

/**
 * This interface contains all operations that all types of shapes should support.
 */
public interface Shape {

  /**
   * Get the id name of this shape.
   *
   * @return the id name of this shape
   */
  String getId();

  /**
   * Get the reference location point of this shape in terms of x and y coordinates.
   *
   * @return end 2d point signaling the location of this shape
   */
  Point2D getLocation();

  /**
   * Return the color this shape.
   *
   * @return the color of this shape
   */
  Color getColor();

  /**
   * Return the width this shape.
   *
   * @return the width of this shape
   */
  int getWidth();

  /**
   * Return the height this shape.
   *
   * @return the height of this shape
   */
  int getHeight();

  /**
   * Update the reference location point of this shape in terms of x and y coordinates.
   *  @param x coordinate x to destiny
   * @param y coordinate y to destiny
   */
  void move(int x, int y);

  /**
   * Update the dimensions of this shape by a given factor.
   *
   * @param factor factor of resizing
   */
  void escale(double factor);

  /**
   * Update the size of this shape to given dimensions.
   *
   * @param width dimension to resize width
   * @param height dimension to resize height
   */
  void resize(int width, int height);

  /**
   * Update the color of this shape.
   *
   * @param color the color to be assigned to this shape
   */
  void changeColor(Color color);

  String getID();

  String getX();

  String getY();

  String getW();

  String getH();

  Integer getR();

  Integer getG();

  Integer getB();

  String getStatus();
}
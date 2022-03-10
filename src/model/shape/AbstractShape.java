package model.shape;

import java.awt.Color;

/**
 * This interface contains all operations that all types of shapes should support.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D location;
  protected int width;
  protected int height;
  protected Color color;
  protected String id;

  /**
   * Constructs a Shape object with the given location of reference and dimensions.
   *
   * @param id the string containing the id name of the shape object
   * @param x      x coordinate of the reference point of the shape
   * @param y      y coordinate of the reference point of the shape
   * @param width  width of this shape
   * @param height height of this shape
   * @param color  color of this shape
   */
  public AbstractShape(String id, int x, int y, int width, int height, Color color) {
    this.location = new Point2D(x, y);
    this.width = width;
    this.height = height;
    this.color = color;
    this.id = id;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public Point2D getLocation() {
    return this.location;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public void move(int x, int y) {
    this.location.updatePosition(x, y);
  }

  @Override
  public void escale(double factor) {
    this.width = (int)Math.floor(factor * this.width);
    this.height = (int)Math.floor(factor * this.height);
  }

  @Override
  public void resize(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public void changeColor(Color color) {
    this.color = color;
  }
}
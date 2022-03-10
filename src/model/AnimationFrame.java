package model;

/**
 * Defines a Animation Frame.
 */
public class AnimationFrame {

  private String name;
  private double t1;
  private double x1;
  private double y1;
  private double w1;
  private double h1;
  private double r1;
  private double g1;
  private double b1;
  private double t2;
  private double x2;
  private double y2;
  private double w2;
  private double h2;
  private double r2;
  private double g2;
  private double b2;

  /**
   * Constructs a animation frame that has motion.
   *
   * @param name the name of shape that will move
   * @param t1 the start time of this motion
   * @param x1 the start x value of this shape
   * @param y1 the start y value of this shape
   * @param w1 the start width of this shape
   * @param h1 the start height of this shape
   * @param r1 the start red value of this shape
   * @param g1 the start green value of this shape
   * @param b1 the start blue value of this shape
   * @param t2 the end time of this motion
   * @param x2 the end x value of this shape
   * @param y2 the end y value of this shape
   * @param w2 the end width of this shape
   * @param h2 the end height of this shape
   * @param r2 the end red value of this shape
   * @param g2 the end green value of this shape
   * @param b2 the end blue value of this shape
   */
  AnimationFrame(String name, double t1, double x1, double y1, double w1, double h1,
                 double r1, double g1, double b1, double t2, double x2, double y2,
                 double w2, double h2, double r2, double g2, double b2) {
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  /**
   * This constructor used when setting up the initial state of a shape.
   *
   * @param name the name of the shape
   * @param t1 the time this shape will appear
   * @param x1 the starting x position of the shape
   * @param y1 the starting y position of the shape
   * @param w1 the starting width of the shape
   * @param h1 the starting height of the shape
   * @param r1 the starting red value of the shape
   * @param g1 the starting green value of the shape
   * @param b1 the starting blue value of the shape
   */
  AnimationFrame(String name, double t1, double x1, double y1, double w1,
                 double h1, double r1, double g1, double b1) {
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t1;
    this.x2 = x1;
    this.y2 = y1;
    this.w2 = w1;
    this.h2 = h1;
    this.r2 = r1;
    this.g2 = g1;
    this.b2 = b1;
  }

  /**
   * Returns the name of the shape of this frame.
   *
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the start time of this frame.
   *
   * @return the t1.
   */
  public double getT1() {
    return t1;
  }

  /**
   * Gets the starting x position of this frame.
   *
   * @return the x1.
   */
  public double getX1() {
    return x1;
  }

  /**
   * Gets the starting y position of this frame.
   *
   * @return the y1.
   */
  public double getY1() {
    return y1;
  }

  /**
   * Gets the starting width of the shape in this frame.
   *
   * @return the w1.
   */
  public double getW1() {
    return w1;
  }

  /**
   * Gets the starting height of the shape in this frame.
   *
   * @return h1.
   */
  public double getH1() {
    return h1;
  }

  /**
   * Gets the starting r value of the shape in this frame.
   *
   * @return the r1.
   */
  public double getR1() {
    return r1;
  }

  /**
   * Gets the starting g value of the shape in this frame.
   *
   * @return the g1.
   */
  public double getG1() {
    return g1;
  }

  /**
   * Gets the starting b value of the shape in this frame.
   *
   * @return the b1.
   */
  public double getB1() {
    return b1;
  }

  /**
   * Gets the start time of this frame.
   *
   * @return the t2.
   */
  public double getT2() {
    return t2;
  }

  /**
   * Gets the starting x position of this frame.
   *
   * @return the x2.
   */
  public double getX2() {
    return x2;
  }

  /**
   * Gets the starting x position of this frame.
   *
   * @return the y2.
   */
  public double getY2() {
    return y2;
  }

  /**
   * Gets the starting width of the shape in this frame.
   *
   * @return the w2.
   */
  public double getW2() {
    return w2;
  }

  /**
   * Gets the starting height of the shape in this frame.
   *
   * @return the h2.
   */
  public double getH2() {
    return h2;
  }

  /**
   * Gets the starting r value of the shape in this frame.
   *
   * @return the r2.
   */
  public double getR2() {
    return r2;
  }

  /**
   * Gets the starting g value of the shape in this frame.
   *
   * @return the g2.
   */
  public double getG2() {
    return g2;
  }

  /**
   * Gets the starting g value of the shape in this frame.
   *
   * @return the g2.
   */
  public double getB2() {
    return b2;
  }
}

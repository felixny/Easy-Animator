package model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Model for the Animation.
 */
public interface AnimationModel {

  /**
   * Gets the state of the model.
   */
  String getState();

  /**
   * Gets width of screen.
   */
  int getWidth();

  /**
   * Gets the state of a shape at a given time.
   *
   * @param t the time to get the state of the animation
   */
  ArrayList<AnimationFrame> interpolate(double t);

  /**
   * Gets height of screen.
   */
  int getHeight();

  /**
   * Gets the largest tick in the animation.
   *
   * @return the int representing the largest time
   */
  double getLargestTime();

  /**
   * Gets the left most x value.
   *
   * @return left most y value
   */
  int getLeftX();

  /**
   * Gets the top most y value.
   *
   * @return top most y value
   */
  int getTopY();

  /**
   * Returns the shape with the given name.
   *
   * @param shape of the shape to be returned
   * @return the shape with the given name
   */
  String getShape(String shape);

  /**
   * Get the size of the hashmap of shapes.
   *
   * @return the size of the hashmap as an int
   */
  int numOfShapes();

  /**
   * Gets the list of animation frames.
   *
   * @return list of animation frames
   */
  ArrayList<AnimationFrame> getAnimationFrames();

  /**
   * Gets the entire map of shapes.
   *
   * @return the map of strings.
   */
  Map<String, String> getAllShapes();
}


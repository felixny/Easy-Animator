package model.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Test cases for the 2DPoint model.
 */
public class Point2DTest {

  @Test
  public void testGetX() {
    Point2D testPoint = new Point2D(4, 5);
    assertEquals(4, testPoint.getX(), 0.001);
  }

  @Test
  public void testGetY() {
    Point2D testPoint = new Point2D(4, 5);
    assertEquals(5, testPoint.getY(), 0.001);
  }

  @Test
  public void testUpdateX() {
    Point2D testPoint = new Point2D(4, 5);
    testPoint.updateX(5);
    assertEquals(5, testPoint.getX(), 0.001);
    assertEquals(5, testPoint.getY(), 0.001);
  }

  @Test
  public void testUpdateY() {
    Point2D testPoint = new Point2D(4, 5);
    testPoint.updateY(0);
    assertEquals(4, testPoint.getX(), 0.001);
    assertEquals(0, testPoint.getY(), 0.001);
  }

  @Test
  public void updatePosition() {
    Point2D testPoint = new Point2D(4, 5);
    testPoint.updatePosition(1, 3);
    assertEquals(1, testPoint.getX(), 0.001);
    assertEquals(3, testPoint.getY(), 0.001);
  }
}
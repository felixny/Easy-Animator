package model.shape;

import org.junit.Test;
import java.awt.Color;
import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Line model.
 */
public class LineTest {

  @Test
  public void testGetStartPoint() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    assertEquals(4, testLine.getStartPoint().getX(), 0.001);
    assertEquals(5, testLine.getStartPoint().getY(), 0.001);
  }

  @Test
  public void testGetEndPoint() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    assertEquals(9, testLine.getEndPoint().getX(), 0.001);
    assertEquals(11, testLine.getEndPoint().getY(), 0.001);
  }


  @Test
  public void testGetColor() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    assertEquals(Color.BLACK, testLine.getColor());
  }

  @Test
  public void testMoveStartPoint() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    testLine.moveStartPoint(1, 2);
    assertEquals(1, testLine.getStartPoint().getX(), 0.001);
    assertEquals(2, testLine.getStartPoint().getY(), 0.001);
  }

  @Test
  public void testMoveEndPoint() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    testLine.moveEndPoint(3, 10);
    assertEquals(3, testLine.getEndPoint().getX(), 0.001);
    assertEquals(10, testLine.getEndPoint().getY(), 0.001);
  }

  @Test
  public void testMove() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    testLine.move(3, 10, 2, 7);
    assertEquals(3, testLine.getStartPoint().getX(), 0.001);
    assertEquals(10, testLine.getStartPoint().getY(), 0.001);
    assertEquals(2, testLine.getEndPoint().getX(), 0.001);
    assertEquals(7, testLine.getEndPoint().getY(), 0.001);
  }

  @Test
  public void testChangeColor() {
    Line testLine = new Line("testShape1", 4, 5, 9, 11, Color.BLACK);
    testLine.changeColor(Color.CYAN);
    assertEquals(Color.CYAN, testLine.getColor());
  }
}
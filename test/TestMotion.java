import org.junit.Test;

import model.motion.Move;
import model.motion.ScaleShape;

import static org.junit.Assert.assertEquals;


/**
 * Tests for methods in Move, ChangeShape.
 */
public class TestMotion {


  public Move move1 = new Move("shape1", 5, 10, 2, 3, 4, 5);
  public ScaleShape scale1 = new ScaleShape("shape2", 2, 5,
          4, 5, 6, 10);


  @Test
  public void getStartTime() {
    assertEquals(5, move1.getStartTime());
  }

  @Test
  public void getEndTime() {
    assertEquals(10, move1.getEndTime());
  }

  @Test
  public void getShapeId() {
    assertEquals("shape1", move1.getShapeId());
  }

  @Test
  public void getStatus() {
    assertEquals("Shape shape1 moves from (2.0, 3.0) to "
                    + "(4.0, 5.0) from time t =5 to t =10",
            move1.getStatus());
  }

  @Test
  public void getX1() {
    assertEquals(2.0, move1.getX1());
  }

  @Test
  public void getX2() {
    assertEquals(4.0, move1.getX2());
  }

  @Test
  public void getY1() {
    assertEquals(3.0, move1.getY1());
  }

  @Test
  public void getY2() {
    assertEquals(5.0, move1.getY2());
  }

  @Test
  public void getStartW() {
    assertEquals(4.0, scale1.getStartW());
  }

  @Test
  public void getStartH() {
    assertEquals(5.0, scale1.getStartH());
  }

  @Test
  public void getEndW() {
    assertEquals(6.0, scale1.getEndW());
  }

  @Test
  public void getEndH() {
    assertEquals(10.0, scale1.getEndH());
  }

  @Test
  public void getStatusScale() {
    assertEquals("Shape shape2 scales from Width: 4.0, Height: 5.0 to "
                    + "Width: 6.0, Height: 10.0 from time t =2 to t =5",
            scale1.getStatus());
  }


}

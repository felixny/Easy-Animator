import static org.junit.Assert.assertEquals;


import org.junit.Test;

import model.AnimationModel;
import model.AnimationModelImpl;

/**
 * Tests for the AnimationModel.
 */
public class AnimationModelTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInconsistentMotionFails() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();
  }

  @Test
  public void testGetState() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    assertEquals("canvas 200 70 360 360\n"
            + "shape O oval\n"
            + "motion O 1.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0  O 1.0 200.0 200.0 50.0 100.0 "
            + "255.0 0.0 0.0\n"
            + "motion O 10.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0  O 50.0 300.0 300.0 50.0 100.0 "
            + "255.0 0.0 0.0\n", m.getState());
  }

  @Test
  public void testGetWidth() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 3600, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    assertEquals(3600, m.getWidth());
  }

  @Test
  public void testGetHeight() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("R", "rectangle")
            .addAnimationFrame("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    assertEquals(360, m.getHeight());
  }

  @Test
  public void testGetShapes() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("R", "rectangle")
            .addAnimationFrame("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    assertEquals("rectangle", m.getShape("R"));
  }

  @Test
  public void testNumOfShapes() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("R", "rectangle")
            .addAnimationFrame("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    assertEquals(1, m.numOfShapes());
  }
}

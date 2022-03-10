import org.junit.Test;

import cs5004.animator.view.VisualView;
import model.AnimationModel;
import model.AnimationModelImpl;

/**
 * Tests AnimationVisualView.
 */
public class AnimationVisualViewTest {


  @Test (expected = IllegalArgumentException.class)
  public void testConstructorBadModel() {
    AnimationModel m = null;

    new VisualView(null, 10);

  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorBadSpeed() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("o", "oval")
            .addAnimationFrame("o", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("o", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    new VisualView(m, -100);

  }
  
}

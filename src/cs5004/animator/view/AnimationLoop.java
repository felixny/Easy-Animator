package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows the animation to loop.
 */
public class AnimationLoop implements ActionListener {

  private final AnimationVisualView view;

  /**
   * Constructs a AnimationLoop.
   *
   * @param view AnimationVisualView that will use this AnimationLoop
   */
  public AnimationLoop(AnimationVisualView view) {
    this.view = view;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    this.view.getPanel().setLoop(!this.view.getPanel().getLoop());
  }
}

package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows an animation to slow down.
 */
public class AnimationSlowDown implements ActionListener {

  private final AnimationVisualView view;

  /**
   * Constructs a AnimationSlowDown.
   *
   * @param view the AnimationVisualView that will use this AnimationSlowDown
   */
  public AnimationSlowDown(AnimationVisualView view) {
    this.view = view;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    return;
  }

  public AnimationVisualView getView() {
    return this.view;
  }
}

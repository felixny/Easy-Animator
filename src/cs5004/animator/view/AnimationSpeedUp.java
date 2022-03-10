package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows an animation to speed up.
 */
public class AnimationSpeedUp implements ActionListener {

  private final AnimationVisualView view;

  /**
   * Constructs a AnimationSpeedUp.
   *
   * @param view is the EnhancedVisualView that will use this AnimationSpeedUp
   */
  public AnimationSpeedUp(AnimationVisualView view) {
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

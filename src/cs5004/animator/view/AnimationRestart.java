package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows an animation to restart.
 */
public class AnimationRestart implements ActionListener {

  private final AnimationVisualView view;

  /**
   * Constructs a AnimationRestart.
   *
   * @param view the AnimationVisualView that will use this AnimationRestart
   */
  public AnimationRestart(AnimationVisualView view) {
    this.view = view;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    this.view.getPanel().setTick(0);
  }
}

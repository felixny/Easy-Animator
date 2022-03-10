package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows the animation to play.
 */
public class AnimationPlay implements ActionListener {

  private final AnimationVisualView view;

  /**
   * Constructs a AnimationPlay.
   *
   * @param view the AnimationVisualView that will use this AnimationPlay
   */
  public AnimationPlay(AnimationVisualView view) {
    this.view = view;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    view.setTitle(view.getPlayTitle().equalsIgnoreCase("Press to pause")
            ? "Press to play" : "Press to pause");
    this.view.getPanel().setTimer();
  }
}

package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import model.AnimationModel;

/**
 * Animation visual view that allows the user to pause, play, restart, loop and change
 * the speed of the animation.
 */
public class AnimationVisualView extends JFrame implements IView, ActionListener {

  private VisualCanvas panel;
  private Appendable ap;

  private AnimationModel model;
  private Timer timer;

  private JButton play;
  private String playTitle;
  private JButton restart = new JButton("Press to restart");
  private JCheckBox loop;
  private JButton speedUp;
  private JButton slowDown = new JButton("Press to slow down");

  /**
   * Constructs an AnimationVisualView.
   *
   * @param model is the model that this view uses
   * @param speed is the base speed of the animation
   */
  public AnimationVisualView(AnimationModel model, int speed) {
    super();
    this.model = model;
    this.panel = new VisualCanvas(model, 2);

    JScrollPane scrollBar;
    scrollBar = new JScrollPane(this.panel,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(scrollBar);

    this.playTitle = "Press to pause";
    this.play = new JButton(this.playTitle);
    panel.add(this.play, BorderLayout.NORTH);
    this.play.addActionListener(new AnimationPlay(this));

    panel.add(this.restart, BorderLayout.NORTH);
    this.restart.addActionListener(new AnimationRestart(this));
    this.loop = new JCheckBox("Toggle to loop");
    panel.add(this.loop, BorderLayout.NORTH);
    this.loop.addActionListener(new AnimationLoop(this));

    this.speedUp = new JButton("Press to speed up");
    panel.add(this.speedUp, BorderLayout.NORTH);
    this.speedUp.addActionListener(new AnimationSpeedUp(this));

    this.slowDown.addActionListener(new AnimationSlowDown(this));

    this.setVisible(true);
    this.pack();
  }

  @Override
  public void visibility() {
    this.setVisible(true);
  }

  VisualCanvas getPanel() {
    return this.panel;
  }

  @Override
  public void setCommandCall(Consumer<String> callback) {
    return;
  }

  @Override
  public void errorMessage(String error) {
    return;
  }

  @Override
  public void refresh() {
    return;
  }

  @Override
  public AnimationModel getAnimatorModel() {
    return this.model;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  public JButton getPlay() {
    return this.play;
  }

  /**
   * Gets the restart button.
   *
   * @return the restart button
   */
  public JButton getRestart() {
    return this.restart;
  }

  /**
   * Gets the loop checkbox.
   *
   * @return the loop checkbox
   */
  public JCheckBox getLoopCheckBox() {
    return this.loop;
  }

  /**
   * Gets the speedup button.
   *
   * @return the speedup button
   */
  public JButton getSpeedUp() {
    return this.speedUp;
  }

  /**
   * Gets the slow down button.
   *
   * @return the slow down button
   */
  public JButton getSlowDown() {
    return this.slowDown;
  }

  /**
   * Increases the timer.
   */
  public void increaseTimer() {
    int num = 100;
  }

  /**
   * Changes the title of the window.
   *
   * @param s is the name of the title
   */
  public void setTitle(String s) {
    this.play.setText(s);
    this.playTitle = s;

  }

  /**
   * Gets the play title.
   *
   * @return the playTitle
   */
  public String getPlayTitle() {
    return this.playTitle;
  }


}

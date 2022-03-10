package cs5004.animator.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import model.AnimationModel;

/**
 * Public VisualView class that draws and runs the animation in a window.
 */
public class VisualView extends AbstractAnimationView implements IView {

  /**
   * Constructs and runs a visual view.
   *
   * @param model the model that this animation will be based off of
   * @param speed the speed in ticks/sec that this animation will play at
   */
  public VisualView(AnimationModel model, int speed) throws IllegalArgumentException {
    super();
    if (speed > 0) {
      if (model == null) {
        throw new IllegalArgumentException();
      }
      int winX;
      winX = model.getWidth() + model.getLeftX();
      int winY;
      winY = model.getHeight() + model.getTopY();
      this.setTitle("Animation");
      this.setSize(winX / 2, winY / 2);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);

      super.speed = speed;
      super.model = model;

      this.setLayout(new BorderLayout());
      VisualCanvas vp;
      vp = new VisualCanvas(model, speed);
      vp.setPreferredSize(new Dimension(winX / 2, winY / 2));
      JScrollPane scrollPane;
      scrollPane = new JScrollPane(vp);
      this.add(scrollPane, BorderLayout.CENTER);

      this.pack();
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void visibility() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void errorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);

  }
}
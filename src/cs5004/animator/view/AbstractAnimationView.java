package cs5004.animator.view;

import java.util.function.Consumer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.AnimationModel;

/**
 * Abstract class for views.
 */
public class AbstractAnimationView extends JFrame implements IView {

  protected AnimationModel model;
  Consumer<String> commandCall;
  int speed;


  @Override
  public void visibility() {
    this.setVisible(true);
  }

  @Override
  public void setCommandCall(Consumer<String> callback) {
    commandCall = callback;
  }


  @Override
  public void errorMessage(String error) {
    JOptionPane.showMessageDialog(this,
            error,
            "Error",
            JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public AnimationModel getAnimatorModel() {
    return model;
  }

}

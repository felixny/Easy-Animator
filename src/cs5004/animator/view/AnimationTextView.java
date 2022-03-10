package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.AnimationModel;

/**
 * Textual view for animations.
 */
public class AnimationTextView extends AbstractAnimationView implements IView {

  /**
   * Constructs a AnimationTextView object based on the model and the output source.
   *
   * @param model the model
   * @param out the way in which the view will be outputted
   */
  public AnimationTextView(AnimationModel model, String out) throws IOException {
    super.model = model;
    if (!out.equals("System.out")) {
      this.createFile(out);
    } else {
      System.out.print(model.getState());
    }
  }

  private void createFile(String out) throws IOException {

    File f;
    f = new File(out);
    FileWriter fw;
    fw = new FileWriter(f);
    fw.write(model.getState());
    fw.close();
  }

  /**
   * Show an error message to the view.
   *
   * @param error message
   */
  @Override
  public void errorMessage(String error) {
    JOptionPane.showMessageDialog(this,
            error,
            "Error",
            JOptionPane.ERROR_MESSAGE);
  }
}

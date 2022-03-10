package cs5004.animator.view;

import java.util.function.Consumer;
import model.AnimationModel;

/**
 * Interface for views.
 */
public interface IView {

  /**
   * Make the view visible.
   */
  void visibility();

  /**
   * Provide the view with a callback option to process a command.
   */
  void setCommandCall(Consumer<String> callback);

  /**
   * Show an error message to the view.
   */
  void errorMessage(String error);

  /**
   * Signal the view to draw itself.
   */
  void refresh();

  /**
   * Returns the model.
   *
   * @return the model
   */
  AnimationModel getAnimatorModel();
}

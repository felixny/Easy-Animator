package controller;

import cs5004.animator.view.IView;
import java.util.Scanner;
import model.AnimationModel;

/**
 * Basic controller.
 */
public class Controller {

  private IView view;

  public Controller(IView v) {
    this.view = v;
    AnimationModel model = v.getAnimatorModel();
  }

  /**
   * Run the command.
   *
   */
  public void runAll() {
    this.view.setCommandCall(s -> {
      try {
        accept(s);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    this.view.visibility();
  }

  /**
   * Outputs the commands that the user specifies.
   *
   * @param command the command that the user specifies
   * @return the commands that the user specifies
   * @throws IllegalStateException if there is not a next
   */
  private String processCommand(String command) throws IllegalStateException {
    StringBuilder string = new StringBuilder();
    Scanner s = new Scanner(command);
    if (s.hasNext()) {
      do {
        String in = s.next();
      }
      while (s.hasNext());
    }

    return string.toString();
  }

  /**
   * Accepts a command to process.
   *
   * @param s is the command that is being accepted
   */
  private void accept(String s) throws Exception {
    String status = "";

    status = processCommand(s);

    view.refresh();
  }
}

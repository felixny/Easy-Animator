import controller.Controller;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.AnimationVisualView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.AnimationTextView;
import cs5004.animator.view.VisualView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.AnimationModel;
import model.AnimationModelImpl.Builder;

/**
 * Main class for the Easy Animator.
 */
public final class EasyAnimator {

  /**
   * The main method for the program.
   *
   * @param args are the arguments passed into the program
   */
  public static void main(String[] args) throws IOException, NullPointerException {
    Readable inputFile;
    inputFile = null;
    String outputPath;
    outputPath = "System.out";
    String view = "";
    int speed = 1000;
    AnimationModel model;

    Controller c = null;

    int i = 0;
    while (i < args.length) {
      if ("-in".equals(args[i])) {
        try {
          inputFile = new FileReader(args[i + 1]);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      } else if ("-out".equals(args[i])) {
        outputPath = args[i + 1];
      } else if ("-view".equals(args[i])) {
        view = args[i + 1];
      } else if ("-speed".equals(args[i])) {
        speed = Integer.parseInt(args[i + 1]);
      }
      i++;
    }

    model = AnimationReader.parseFile(inputFile, new Builder());

    if ("text".equals(view)) {
      c = new Controller(new AnimationTextView(model, outputPath));
    } else if ("svg".equals(view)) {
      c = new Controller(new SVGView(model, outputPath, speed));
    } else if ("visual".equals(view)) {
      c = new Controller(new VisualView(model, speed));
    } else if ("interactive".equals(view)) {
      c = new Controller(new AnimationVisualView(model, speed));
    }

    c.runAll();
  }
}
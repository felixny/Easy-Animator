import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import cs5004.animator.view.AnimationTextView;
import cs5004.animator.view.IView;
import model.AnimationModel;
import model.AnimationModelImpl;
import org.junit.Test;

/**
 * Tests for the AnimationTextView.
 */
public class AnimationTextViewTest {

  @Test
  public void testMakeFile() throws IOException {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    IView v = new AnimationTextView(m, "E:\\Output\\test.txt");

    File f = new File("E:\\Output\\test.txt");
    assertTrue(f.exists());
  }

  @Test
  public void testTextFromFile() throws IOException {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "Oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();
    IView v = new AnimationTextView(m, "E:\\Output\\test.txt");
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get("E:\\Output\\test.txt")),
              "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("canvas 200 70 360 360\n"
            + "shape O Oval\n"
            + "motion O 1.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0  "
            + "O 1.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0\n"
            + "motion O 10.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0  "
            + "O 50.0 300.0 300.0 50.0 100.0 255.0 0.0 0.0\n", content);
  }

  @Test
  public void testPrintToConsole() throws IOException {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    IView v = new AnimationTextView(m, "System.out");

    assertEquals("canvas 200 70 360 360\n"
            + "shape O oval\n"
            + "motion O 1.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0  "
            + "O 1.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0\n"
            + "motion O 10.0 200.0 200.0 50.0 100.0 255.0 0.0 0.0  "
            + "O 50.0 300.0 300.0 50.0 100.0 255.0 0.0 0.0\n", m.getState());
  }
  
}

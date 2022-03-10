import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import cs5004.animator.view.IView;
import cs5004.animator.view.SVGView;
import model.AnimationModel;
import model.AnimationModelImpl;

/**
 * Tests for the SVGView.
 */
public class AnimationSVGViewTest {

  @Test
  public void testMakeFile() throws IOException {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();

    IView v = new SVGView(m, "D:\\Output\\test.svg", 100);

    File f = new File("D:\\Output\\test.svg");
    assertTrue(f.exists());
  }

  @Test
  public void testCorrectStringOutputOval() throws IOException {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("O", "oval")
            .addAnimationFrame("O", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("O", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();
    IView v = new SVGView(m, "D:\\Output\\test.svg", 100);
    String content = "";
    content = new String(Files.readAllBytes(Paths.get("D:\\Output\\test.svg")),
            "UTF-8");

    assertEquals("<svg width=\"560\" height=\"430\" version=\"1.1\"\n"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n"
            + "<oval id=\"O\" cx=\"200.0\" cy=\"200.0\" rx=\"50.0\" ry=\"100.0\" fill=\""
            + "rgb(255.0, 0.0, 0.0)\" "
            + "visibility=\"visible\" >\n"
            + "<animate attributeName=\"x\" attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"200.0\" />\n"
            + "<animate attributeName=\"y\" attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"200.0\" />\n"
            + "<animate attributeName=\"width\" attributeType=\"xml\" "
            + "begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"50.0\" to=\"50.0\" />\n"
            + "<animate attributeName=\"height\" attributeType=\"xml\" "
            + "begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"100.0\" to=\"100.0\" />\n"
            + "<animate attributeName=\"x\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"300.0\" />\n"
            + "<animate attributeName=\"y\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"300.0\" />\n"
            + "<animate attributeName=\"width\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"50.0\" to=\"50.0\" />\n"
            + "<animate attributeName=\"height\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"100.0\" to=\"100.0\" />\n"
            + "</oval>\n"
            + "</svg>", content);

  }

  @Test
  public void testCorrectStringOutputRectangle() throws IOException {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(200, 70, 360, 360)
            .declareShape("R", "rectangle")
            .addAnimationFrame("R", 1, 200, 200, 50, 100, 255, 0, 0)
            .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
                    300, 300, 50, 100, 255, 0, 0)
            .build();
    IView v = new SVGView(m, "C:\\Easy Animator Output\\test.svg", 100);
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get("C:\\Easy Animator Output\\test.svg")),
              "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("<svg width=\"560\" height=\"430\" version=\"1.1\"\n"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n"
            + "<rectangle id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\" fill=\""
            + "rgb(255.0, 0.0, 0.0)\" "
            + "visibility=\"visible\" >\n"
            + "<animate attributeName=\"x\" attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"200.0\" />\n"
            + "<animate attributeName=\"y\" attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"200.0\" />\n"
            + "<animate attributeName=\"width\" attributeType=\"xml\" "
            + "begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"50.0\" to=\"50.0\" />\n"
            + "<animate attributeName=\"height\" attributeType=\"xml\" "
            + "begin=\"100.0ms\" dur=\"0.0ms\" "
            + "fill=\"freeze\" from=\"100.0\" to=\"100.0\" />\n"
            + "<animate attributeName=\"x\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"300.0\" />\n"
            + "<animate attributeName=\"y\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"200.0\" to=\"300.0\" />\n"
            + "<animate attributeName=\"width\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"50.0\" to=\"50.0\" />\n"
            + "<animate attributeName=\"height\" attributeType=\"xml\" "
            + "begin=\"1000.0ms\" dur=\"4000.0ms\" "
            + "fill=\"freeze\" from=\"100.0\" to=\"100.0\" />\n"
            + "</rectangle>\n"
            + "</svg>", content);

  }

}

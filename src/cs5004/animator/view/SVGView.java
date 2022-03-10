package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.AnimationFrame;
import model.AnimationModel;

/**
 * Defines a view outputs SVG files.
 */
public class SVGView extends AbstractAnimationView implements IView {

  Appendable append = null;

  /**
   * Constructs a view that outputs an svg file.
   *
   * @param model the model that this svg file will be based off of
   * @param out the output path
   * @param speed the speed that this svg file will run the animation at
   */
  public SVGView(AnimationModel model, String out, int speed) throws IOException {
    super.model = model;
    super.speed = speed;
    this.createSVGFile(out);
  }

  /**
   * Creates the format of the SVG view.
   *
   * @return a string representing the SVG view
   */
  public String createSVG() {
    StringBuilder sb = new StringBuilder();

    sb.append("<svg width=\"").append(model.getWidth()
            + model.getLeftX()).append("\" height=\"").append(model.getHeight()
            + model.getTopY()).append("\" version=\"1.1\"\n")
            .append("xmlns=\"http://www.w3.org/2000/svg\">\n");

    model.getAllShapes().keySet().forEach(s -> {
      if (model.getShape(s).equals("rectangle")) {
        sb.append(this.rectangleSVG(s));
      } else {
        sb.append(this.ovalSVG(s));
      }
    });

    sb.append("</svg>");

    return sb.toString();

  }

  /**
   * Creates oval SVG string.
   *
   * @param name string name
   * @return oval string
   */
  private StringBuilder ovalSVG(String name) {
    StringBuilder oval;
    oval = new StringBuilder();

    AnimationFrame base;
    base = null;

    int i = 0;
    while (i < model.getAnimationFrames().size()) {
      AnimationFrame temp = model.getAnimationFrames().get(i);
      if (temp.getName().equals(name)) {
        base = temp;
        break;
      }
      i++;
    }

    oval.append("<oval id=\"").append(name).append("\" cx=\"").append(base.getX1())
            .append("\" cy=\"").append(base.getY1()).append("\" rx=\"").append(base.getW1())
            .append("\" ry=\"").append(base.getH1()).append("\" fill=\"rgb(").append(base.getR1())
            .append(", ").append(base.getG1()).append(", ").append(base.getB1())
            .append(")\" visibility=\"visible\" >\n");

    for (Iterator<AnimationFrame> iterator = model.getAnimationFrames().iterator();
         iterator.hasNext(); ) {
      AnimationFrame k = iterator.next();
      if (k.getName().equals(name)) {
        oval.append("<animate attributeName=\"x\" ");
        oval.append("attributeType=\"xml\" ");
        oval.append("begin=\"");
        oval.append(k.getT1() * super.speed);
        oval.append("ms\"");
        oval.append(" dur=\"");
        oval.append((k.getT2() - k.getT1()) * super.speed);
        oval.append("ms\" fill=\"freeze\"");
        oval.append(" from=\"");
        oval.append(k.getX1());
        oval.append("\"");
        oval.append(" to=\"");
        oval.append(k.getX2());
        oval.append("\"");
        oval.append(" />\n");
        oval.append("<animate attributeName=\"y\" ");
        oval.append("attributeType=\"xml\" ");
        oval.append("begin=\"");
        oval.append(k.getT1() * super.speed);
        oval.append("ms\"");
        oval.append(" dur=\"");
        oval.append((k.getT2() - k.getT1()) * super.speed);
        oval.append("ms\" fill=\"freeze\"");
        oval.append(" from=\"");
        oval.append(k.getY1());
        oval.append("\"");
        oval.append(" to=\"");
        oval.append(k.getY2());
        oval.append("\"");
        oval.append(" />\n");
        oval.append("<animate attributeName=\"width\" ");
        oval.append("attributeType=\"xml\" ");
        oval.append("begin=\"");
        oval.append(k.getT1() * super.speed);
        oval.append("ms\"");
        oval.append(" dur=\"");
        oval.append((k.getT2() - k.getT1()) * super.speed);
        oval.append("ms\" fill=\"freeze\"");
        oval.append(" from=\"");
        oval.append(k.getW1());
        oval.append("\"");
        oval.append(" to=\"");
        oval.append(k.getW2());
        oval.append("\"");
        oval.append(" />\n");
        oval.append("<animate attributeName=\"height\" ");
        oval.append("attributeType=\"xml\" ");
        oval.append("begin=\"");
        oval.append(k.getT1() * super.speed);
        oval.append("ms\"");
        oval.append(" dur=\"");
        oval.append((k.getT2() - k.getT1()) * super.speed);
        oval.append("ms\" fill=\"freeze\"");
        oval.append(" from=\"");
        oval.append(k.getH1());
        oval.append("\"");
        oval.append(" to=\"");
        oval.append(k.getH2());
        oval.append("\"");
        oval.append(" />\n");
      }
    }

    oval.append("</oval>\n");

    return oval;
  }

  /**
   * Creates rectangle SVG string.
   *
   * @param name string name
   * @return rectangle string
   */
  private StringBuilder rectangleSVG(String name) {
    StringBuilder rectangle;
    rectangle = new StringBuilder();

    AnimationFrame base;
    base = null;

    int i = 0;
    while (i < model.getAnimationFrames().size()) {
      AnimationFrame temp = model.getAnimationFrames().get(i);
      if (temp.getName().equals(name) && temp.getT1() == 1) {
        base = temp;
        break;
      }
      i++;
    }

    rectangle.append("<rectangle id=\"").append(name).append("\" x=\"").append(base.getX1())
            .append("\" y=\"").append(base.getY1()).append("\" width=\"").append(base.getW1())
            .append("\" height=\"").append(base.getH1()).append("\" fill=\"rgb(")
            .append(base.getR1()).append(", ").append(base.getG1()).append(", ")
            .append(base.getB1()).append(")\" visibility=\"visible\" >\n");

    for (Iterator<AnimationFrame> iterator = model.getAnimationFrames().iterator();
         iterator.hasNext(); ) {
      AnimationFrame k = iterator.next();
      if (k.getName().equals(name)) {
        rectangle.append("<animate attributeName=\"x\" ");
        rectangle.append("attributeType=\"xml\" ");
        rectangle.append("begin=\"");
        rectangle.append(k.getT1() * super.speed);
        rectangle.append("ms\"");
        rectangle.append(" dur=\"");
        rectangle.append((k.getT2() - k.getT1()) * super.speed);
        rectangle.append("ms\" fill=\"freeze\"");
        rectangle.append(" from=\"");
        rectangle.append(k.getX1());
        rectangle.append("\"");
        rectangle.append(" to=\"");
        rectangle.append(k.getX2());
        rectangle.append("\"");
        rectangle.append(" />\n");
        rectangle.append("<animate attributeName=\"y\" ");
        rectangle.append("attributeType=\"xml\" ");
        rectangle.append("begin=\"");
        rectangle.append(k.getT1() * super.speed);
        rectangle.append("ms\"");
        rectangle.append(" dur=\"");
        rectangle.append((k.getT2() - k.getT1()) * super.speed);
        rectangle.append("ms\" fill=\"freeze\"");
        rectangle.append(" from=\"");
        rectangle.append(k.getY1());
        rectangle.append("\"");
        rectangle.append(" to=\"");
        rectangle.append(k.getY2());
        rectangle.append("\"");
        rectangle.append(" />\n");
        rectangle.append("<animate attributeName=\"width\" ");
        rectangle.append("attributeType=\"xml\" ");
        rectangle.append("begin=\"");
        rectangle.append(k.getT1() * super.speed);
        rectangle.append("ms\"");
        rectangle.append(" dur=\"");
        rectangle.append((k.getT2() - k.getT1()) * super.speed);
        rectangle.append("ms\" fill=\"freeze\"");
        rectangle.append(" from=\"");
        rectangle.append(k.getW1());
        rectangle.append("\"");
        rectangle.append(" to=\"");
        rectangle.append(k.getW2());
        rectangle.append("\"");
        rectangle.append(" />\n");
        rectangle.append("<animate attributeName=\"height\" ");
        rectangle.append("attributeType=\"xml\" ");
        rectangle.append("begin=\"");
        rectangle.append(k.getT1() * super.speed);
        rectangle.append("ms\"");
        rectangle.append(" dur=\"");
        rectangle.append((k.getT2() - k.getT1()) * super.speed);
        rectangle.append("ms\" fill=\"freeze\"");
        rectangle.append(" from=\"");
        rectangle.append(k.getH1());
        rectangle.append("\"");
        rectangle.append(" to=\"");
        rectangle.append(k.getH2());
        rectangle.append("\"");
        rectangle.append(" />\n");
      }
    }

    rectangle.append("</rectangle>\n");

    return rectangle;
  }

  private void createSVGFile(String out) throws IOException {

    File f = new File(out);
    FileWriter fw = new FileWriter(f);
    fw.write(this.createSVG());
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

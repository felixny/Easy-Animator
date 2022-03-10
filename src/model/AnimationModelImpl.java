package model;

import cs5004.animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An implementation of the AnimatorModel interface.
 */
public final class AnimationModelImpl implements AnimationModel {

  private int winHeight;
  private int winWidth;
  private int leftX;
  private int topY;
  private Map<String, String> shapes;
  private ArrayList<String> shapes2;
  private ArrayList<AnimationFrame> keyFrames;

  private AnimationModelImpl(Builder b) {
    this.shapes = b.shapes;
    this.shapes2 = b.shapes2;
    this.keyFrames = b.keyFrames;
    this.winHeight = b.winHeight;
    this.winWidth = b.winWidth;
    this.leftX = b.leftX;
    this.topY = b.topY;
  }

  @Override
  public String getState() {
    StringBuilder string;
    string = new StringBuilder();

    string.append("canvas ");
    string.append(this.leftX);
    string.append(" ");
    string.append(this.topY);
    string.append(" ");
    string.append(this.winWidth);
    string.append(" ");
    string.append(this.winHeight);
    string.append("\n");

    shapes.keySet().forEach(s -> {
      string.append("shape ").append(s).append(" ").append(shapes.get(s)).append("\n");
      keyFrames.stream().filter(k -> k.getName().equals(s)).forEach(k -> {
        string.append("motion ").append(s).append(" ").append(k.getT1()).append(" ")
                .append(k.getX1()).append(" ").append(k.getY1()).append(" ").append(k.getW1())
                .append(" ").append(k.getH1()).append(" ").append(k.getR1()).append(" ")
                .append(k.getG1()).append(" ").append(k.getB1());
        string.append("  ").append(s).append(" ").append(k.getT2()).append(" ").append(k.getX2())
                .append(" ").append(k.getY2()).append(" ").append(k.getW2()).append(" ")
                .append(k.getH2()).append(" ").append(k.getR2()).append(" ").append(k.getG2())
                .append(" ").append(k.getB2()).append("\n");
      });
    });

    return string.toString();
  }

  /**
   * Constructs a animation frame that has motion.
   *
   * @param tick the tick that this will occur at
   * @return the new interpolated animation frame
   */
  public ArrayList<AnimationFrame> interpolate(double tick) {

    ArrayList<AnimationFrame> interpolateKeyFrame = new ArrayList<>();

    for (Iterator<AnimationFrame> iterator = this.keyFrames.iterator(); iterator.hasNext(); ) {
      AnimationFrame k = iterator.next();
      if (k.getT2() - k.getT1() != 0) {
        if (tick >= k.getT1() && tick <= k.getT2()) {
          double newX = (k.getX1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + (k.getX2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));
          double newY = (k.getY1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + (k.getY2() * (
                  (tick - k.getT1()) / (k.getT2() - k.getT1())));
          double newWidth = (k.getW1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + (k.getW2() * (
                  (tick - k.getT1()) / (k.getT2() - k.getT1())));
          double newHeight = (k.getH1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + ((k.getH2() * ((tick - k.getT1()) / (k.getT2() - k.getT1()))));
          double newR = (k.getR1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + (k.getR2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));
          double newG = (k.getG1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + (k.getG2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));
          double newB = (k.getB1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
                  + (k.getB2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));

          interpolateKeyFrame.add(
                  new AnimationFrame(k.getName(), tick, newX, newY, newWidth, newHeight, newR, newG,
                          newB,
                          tick, newX, newY, newWidth, newHeight, newR, newG, newB));
        }
      } else {
        interpolateKeyFrame.add(k);
      }
    }
    return interpolateKeyFrame;

  }

  @Override
  public int getWidth() {
    return this.winWidth;
  }

  @Override
  public int getHeight() {
    return this.winHeight;
  }

  public int getLeftX() {
    return this.leftX;
  }

  public int getTopY() {
    return this.topY;
  }

  @Override
  public String getShape(String shape) {
    return shapes.get(shape);
  }

  @Override
  public ArrayList<AnimationFrame> getAnimationFrames() {
    return this.keyFrames;
  }

  @Override
  public Map<String, String> getAllShapes() {
    return this.shapes;
  }

  @Override
  public int numOfShapes() {
    return this.shapes.size();
  }


  @Override
  public double getLargestTime() {
    double max = 0;
    for (Iterator<AnimationFrame> iterator = keyFrames.iterator(); iterator.hasNext(); ) {
      AnimationFrame k = iterator.next();
      if (k.getT2() > max) {
        max = k.getT2();
      }
    }
    return max;

  }

  /**
   * Represents the builder.
   */
  public static final class Builder implements AnimationBuilder<AnimationModel> {

    Map<String, String> shapes = new LinkedHashMap<>();
    int leftX;
    int topY;
    int winHeight;
    int winWidth;
    private ArrayList<AnimationFrame> keyFrames;

    {
      keyFrames = new ArrayList<>();
    }

    private ArrayList<String> shapes2;

    {
      shapes2 = new ArrayList<>();
    }

    @Override
    public AnimationModel build() {
      return new AnimationModelImpl(this);
    }

    @Override
    public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
      this.leftX = x;
      this.topY = y;
      this.winHeight = height;
      this.winWidth = width;
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
      shapes.keySet().stream().filter(name::equals).forEach(s -> {
        throw new IllegalArgumentException("Cannot have two shapes with the same name");
      });
      shapes2.add(name);
      shapes.put(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name, int t1, int x1, int y1, int w1,
                                                      int h1, int r1, int g1, int b1, int t2,
                                                      int x2, int y2, int w2, int h2, int r2,
                                                      int g2, int b2) {

      keyFrames.stream().filter(k -> k.getName().equals(name) && k.getT1() >= t1 && t2
              <= k.getT2()).forEach(k -> {
                throw new IllegalArgumentException("Cannot have inconsistent motions");
              });

      this.keyFrames.add(new AnimationFrame(name, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x2, y2, w2, h2, r2, g2, b2));
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addAnimationFrame(String name, int t, int x, int y,
                                                              int w, int h, int r, int g, int b) {
      this.keyFrames.add(new AnimationFrame(name, t, x, y, w, h, r, g, b));

      return this;
    }
  }
}
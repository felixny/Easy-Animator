package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.AnimationFrame;
import model.AnimationModel;

/**
 * Defines a canvas that will be drawn onto.
 */
public class VisualCanvas extends JPanel implements ActionListener {

  private Map<String, String> shapes;
  private ArrayList<AnimationFrame> allKey;
  private double tick;
  private AnimationModel model;
  private boolean loop;
  private Timer timer;
  private boolean isPlay;


  /**
   * Constructs a shape canvas object and sets the background to white.
   */
  VisualCanvas(AnimationModel model, int speed) {
    super();
    this.model = model;
    this.tick = 0;
    timer = new Timer(1000 / speed, this);
    this.shapes = model.getAllShapes();
    this.setBackground(Color.WHITE);
    loop = false;
    isPlay = true;
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d;
    g2d = (Graphics2D) g;

    AffineTransform originalTransform;
    originalTransform = g2d.getTransform();

    g2d.translate(1, this.getPreferredSize().getHeight());
    g2d.scale(0.5, 0.5);

    for (Iterator<String> iterator = shapes.keySet().iterator(); iterator.hasNext(); ) {
      String s = iterator.next();
      int i = 0;
      int akSize = allKey.size();
      while (i < akSize) {
        AnimationFrame k = allKey.get(i);
        if (tick >= k.getT1() && tick <= k.getT2()) {
          g2d.setColor(new Color((int) k.getR1(), (int) k.getG1(), (int) k.getB1()));
        }
        if (shapes.get(k.getName()).equals("rectangle") && s.equals(k.getName())) {
          g2d.fillRect((int) k.getX1(), (int) k.getY1(), (int) k.getW1(), (int) k.getH1());
        }
        if (shapes.get(k.getName()).equals("oval") && s.equals(k.getName())) {
          g2d.fillOval((int) k.getX1(), (int) k.getY1(), (int) k.getW1(), (int) k.getH1());
        }
        i++;
      }
    }
    g2d.setTransform(originalTransform);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    tick++;
    this.allKey = this.model.interpolate(tick);
    if (model.getLargestTime() <= tick && loop) {
      tick = 0;
      if (model.getLargestTime() <= tick && !loop) {
        this.allKey = model.interpolate(this.model.getLargestTime());
        tick = model.getLargestTime();
      }
    } else {
      if (model.getLargestTime() <= tick && !loop) {
        this.allKey = model.interpolate(this.model.getLargestTime());
        tick = model.getLargestTime();
      }
    }
    repaint();
  }

  /**
   * Sets the tick of the animation.
   *
   * @param tick the new tick the animation will play from
   */
  public void setTick(int tick) {
    this.tick = tick;
  }

  /**
   * Sets whether to loop the animation.
   *
   * @param loop whether the animation will loop
   */
  public void setLoop(boolean loop) {
    this.loop = loop;
  }

  /**
   * Gets whether the animation will loop.
   *
   * @return whether the animation will loop
   */
  public boolean getLoop() {
    return this.loop;
  }

  /**
   * Sets a timer for this animation.
   */
  public void setTimer() {
    if (!this.isPlay) {
      timer.start();
    } else {
      timer.stop();
    }
    this.isPlay = !this.isPlay;
  }
}

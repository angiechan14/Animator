package cs3500.animator.view;

import javax.swing.*;

import cs3500.animator.model.AShape;
import cs3500.animator.model.RectangleShape;

import java.awt.*;

public class ShapePanel extends JPanel {
  private AShape shape;

  public ShapePanel(AShape shape) {
    this.shape = shape;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (shape.getClass().equals(RectangleShape.class)) {

      g.drawRect((int) shape.getX(), (int) shape.getY(), (int) shape.getXSize(),
              (int) shape.getYSize());
    }
    else {
      g.drawOval((int) shape.getX(), (int) shape.getY(), (int) shape.getXSize(),
              (int) shape.getYSize());
    }
  }



}

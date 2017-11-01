package cs3500.animator.model;

import java.awt.Color;

/** Rectangle shape that extends the AShape abstract class. Used for representing a rectangle.
 */
public class RectangleShape extends AShape {
  private double width;
  private double height;

  /**
   * Constructor for a rectangle shape.
   */
  public RectangleShape(double x, double y, Color color, String name, int timeAppear,
                        int timeRemove, double width, double height) {
    super(x, y, color, name, timeAppear, timeRemove);
    this.width = width;
    this.height = height;
  }

  @Override
  public String getPrint() {
    return "rectangle\n" +
            "Lower-left corner: " +
            formatLocation() +
            ", Width: " +
            String.valueOf(width) +
            " Height: " +
            String.valueOf(height);
  }

  @Override
  public void resize(double newWidth, double newHeight) {
    this.width = newWidth;
    this.height = newHeight;
  }

  @Override
  public String svgShape() {
    return "<rect id=\"" + getName() + "\" x=\"" + getX() + "\" y=\"" + getY() + "\" width=\""
            + width + "\" height=\"" + height + "\" fill=\"" + getColorString() + "\""
            + "visibility=\"visible\">";
  }

  @Override
  public String svgEnd() {
    return "</rect>";
  }

  @Override
  public double getXSize() {
    return width;
  }

  @Override
  public double getYSize() {
    return height;
  }
}

package cs3500.hw05;

import java.awt.Color;

/** Oval shape that extends the AShape abstract class. Used for representing an oval.
 */
public class OvalShape extends AShape {
  private double xRad;
  private double yRad;

  /** Constructor for an Oval Shape.
   */
  public OvalShape(double x, double y, Color color, String name, int timeAppear,
                        int timeRemove, double xRad, double yRad) {
    super(x, y, color, name, timeAppear, timeRemove);
    this.xRad = xRad;
    this.yRad = yRad;
  }

  @Override
  String getPrint() {
    return "oval\n" +
            "Center: " +
            formatLocation() +
            ", X radius: " +
            String.valueOf(xRad) +
            " Y radius: " +
            String.valueOf(yRad);
  }

  @Override
  public void resize(double newWidth, double newHeight) {
    this.xRad = newWidth;
    this.yRad = newHeight;
  }

  @Override
  public double getXSize() {

    return xRad;
  }

  @Override
  public double getYSize() {

    return yRad;
  }


}

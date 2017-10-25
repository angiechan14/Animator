package cs3500.hw05.model;

import java.awt.Color;

/** Command for a changing color.
 */
public class ChangeCommand extends ACommand {

  private Color newColor;
  private int rPerTick;
  private int gPerTick;
  private int bPerTick;

  /** Constructor for a changing color command. This is where the command decides how much to
   * change the shape each tick.
   */
  public ChangeCommand(AShape shape, int startTime, int endTime, String name, Color newColor) {
    super(shape, startTime, endTime, name);
    this.newColor = newColor;
    this.rPerTick = (newColor.getRed() - shape.getColor().getRed()) / (endTime - startTime);
    this.gPerTick = (newColor.getGreen() - shape.getColor().getGreen()) / (endTime - startTime);
    this.bPerTick = (newColor.getBlue() - shape.getColor().getBlue()) / (endTime - startTime);
  }

  @Override
  public String getMove(AShape shape) {
    return "changes color from " + shape.getColorString() +  " to "
            + newColor.toString().substring(14) + " ";
  }

  @Override
  public void command(AShape shape, int curTime) {
    if (curTime == getEndTime()) {
      shape.recolor(newColor);
    }
    else {
      int curR = shape.getColor().getRed() + rPerTick;
      int curG = shape.getColor().getGreen() + gPerTick;
      int curB = shape.getColor().getBlue() + bPerTick;

      shape.recolor(new Color(curR, curG, curB));
    }
  }
}

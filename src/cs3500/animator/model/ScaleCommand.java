package cs3500.animator.model;


/** Command for scaling a shape.
 */
public class ScaleCommand extends ACommand {

  private double newXSize;
  private double newYSize;
  private double xSizePerTick;
  private double ySizePerTick;

  /** Constructor for a scale command. Where it decides on how much to change the shape each tick.
   */
  public ScaleCommand(AShape shape, int startTime, int endTime, double newXSize, double newYSize) {
    super(shape, startTime, endTime);
    this.newXSize = newXSize;
    this.newYSize = newYSize;
    this.xSizePerTick = newXSize - shape.getXSize() / (endTime - startTime);
    this.ySizePerTick = newYSize - shape.getYSize() / (endTime - startTime);
  }

  @Override
  public String getMove(AShape shape) {
    return "scales from (" + String.valueOf(shape.getXSize()) + ","
            + String.valueOf(shape.getYSize()) + ") to ("
            + String.valueOf(newXSize) + "," + String.valueOf(newYSize) + ") ";
  }

  @Override
  public void command(AShape shape, int curTime) {
    if (curTime == getEndTime()) {
      shape.resize(newXSize, newYSize);
    }
    else {
      double curXSize = shape.getXSize() + xSizePerTick;
      double curYSize = shape.getYSize() + ySizePerTick;

      shape.resize(curXSize, curYSize);
    }
  }

  @Override
  public String svgCommand() {
    return "<animate attributeType=\"xml\" begin=\"" + getStartTime() * 1000 + "ms\" dur=\""
            + (getEndTime() - getStartTime()) * 1000 + "ms\" attributeName=\"x\" from=\""
            + getShape().getXSize() + "\" " + "to=\"" + newXSize + "\" fill=\"freeze\"/>"
            + "<animate attributeType=\"xml\" begin=\"" + getStartTime() * 1000 + "ms\" dur=\""
            + (getEndTime() - getStartTime()) * 1000 + "ms\" attributeName=\"y\" from=\""
            + getShape().getYSize() + "\" " + "to=\"" + newYSize + "\" fill=\"freeze\"/>";
  }
}

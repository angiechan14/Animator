package cs3500.animator.model;

/** Command to move a shape.
 */
public class MoveCommand extends ACommand {

  private double newX;
  private double newY;
  private double perTickX;
  private double perTickY;

  /** Constructor for a move command. Where it decides how much to change the shape.
   */
  public MoveCommand(AShape shape, int startTime, int endTime, double newX, double newY) {
    super(shape, startTime, endTime);
    this.newX = newX;
    this.newY = newY;
    this.perTickX = (newX - shape.getX()) / (endTime - startTime);
    this.perTickY = (newY - shape.getY()) / (endTime - startTime);
  }

  @Override
  public String getMove(AShape shape) {
    return "moves from (" + String.valueOf(shape.getX()) + "," + String.valueOf(shape.getY())
            + ") to (" + String.valueOf(newX) + "," + String.valueOf(newY) + ") ";
  }

  /** Makes the gradient in the else case.
   */
  @Override
  public void command(AShape shape, int curTime) {
    if (curTime == getEndTime()) {
      shape.move(newX, newY);
    }
    else {
      double curX = shape.getX() + perTickX;
      double curY = shape.getY() + perTickY;

      shape.move(curX, curY);
    }
  }

  @Override
  public String svgCommand() {
    return "<animate attributeType=\"xml\" begin=\"" + getStartTime() * 1000 + "ms\" dur=\""
            + (getEndTime() - getStartTime()) * 1000 + "ms\" attributeName=\"x\" from=\""
            + getShape().getX() + "\" " + "to=\"" + newX + "\" fill=\"freeze\"/>"
            + "<animate attributeType=\"xml\" begin=\"" + getStartTime() * 1000 + "ms\" dur=\""
            + (getEndTime() - getStartTime()) * 1000 + "ms\" attributeName=\"y\" from=\""
            + getShape().getY() + "\" " + "to=\"" + newY + "\" fill=\"freeze\"/>";
  }
}

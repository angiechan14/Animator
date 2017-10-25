package cs3500.hw05.model;

/** Command to move a shape.
 */
public class MoveCommand extends ACommand {

  private double newX;
  private double newY;
  private double perTickX;
  private double perTickY;

  /** Constructor for a move command. Where it decides how much to change the shape.
   */
  public MoveCommand(AShape shape, int startTime, int endTime, String name,
                     double newX, double newY) {
    super(shape, startTime, endTime, name);
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
}

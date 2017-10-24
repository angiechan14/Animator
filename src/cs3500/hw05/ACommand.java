package cs3500.hw05;

/** Abstract class that defines some behavior for given commands and can be extended by new
 * commands should they be added.
 * Each extended class gets to define its own behavior for what happens on each tick.
 * I chose to make this an abstract class because I thought it would be easy to add new
 * functionality and different commands in the future. It also saves a lot of duplicated code
 * because some command functionality is the same between all commands.
 */
public abstract class ACommand {
  private AShape shape;
  private int startTime;
  private int endTime;
  private String name;

  /** Abstract constructor that defines the constructor that is common to all commands.
   */
  ACommand(AShape shape, int startTime, int endTime, String name) {
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.name = name;
    }


  /** Getter for the start time.
   */
  public int getStartTime() {

    return startTime;
  }

  /** Getter for the end time.
   */
  public int getEndTime() {
    return endTime;
  }

  /** Getter for the shape.
   */
  public AShape getShape() {
    return shape;
  }


  /** Used for the common parts of writing the instructions out.
   */
  public String printCommand() {
    return "Shape " +
            shape.getName() +
            " " +
            getMove(shape) +
            "from t=" +
            String.valueOf(startTime) +
            " to t=" +
            String.valueOf(endTime) + "\n";
  }

  /** Abstracted out the uncommon parts of writing the instructions out.
   */
  public abstract String getMove(AShape shape);

  /** This method handles the actual commands for each extension of ACommand.
   *  It handles the gradient for all of the commands given the current time.
   */
  public abstract void command(AShape shape, int curTime);

  public enum CommandType {
    MOVE, CHANGE, SCALE
  }


}

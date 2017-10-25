package cs3500.hw05.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This is the interface of the Animator Model. It defines the behavior of the model.
 */

public class AnimatorModel implements AnimatorOperations {

  private List<AShape> shapeList;
  private List<ACommand> actionList;
  private int timeMultiplier;

  /**
   * This is the interface of the Animator Model. It defines the behavior of the model.
   */

  public AnimatorModel() {
    shapeList = new ArrayList<>();
    actionList = new ArrayList<>();
    timeMultiplier = 0;
  }

  @Override
  public void startAnimation(List<AShape> shapeList, List<ACommand> actionList,
                             int timeMultiplier) {
    this.shapeList = shapeList;
    this.actionList = actionList;
    this.timeMultiplier = timeMultiplier;

    // sorts action list by startingTime
    actionList.sort(Comparator.comparingInt(ACommand::getStartTime));

    if (badCommands(actionList)) {
      throw new IllegalArgumentException("Cannot have two of the same commands " +
              "happening at the same time on the same shape.");
    }
  }

  @Override
  public void move(ACommand curCommand, int curTime) {
    curCommand.command(curCommand.getShape(), curTime * timeMultiplier);
  }

  @Override
  public void addShape(String name, AShape.ShapeType type, int x, int y, Color color,
                       int timeAppear, int timeDisappear, int xSize, int ySize) {

  }

  @Override
  public void removeShape(String name) {

  }

  @Override
  public void addCommand(String name) {

  }

  @Override
  public void removeCommand(String name) {

  }

  @Override
  public String printInstructions() {
    if (actionList.isEmpty() && shapeList.isEmpty()) {
      return "";
    }
    else {
      StringBuilder instruct = new StringBuilder();

      instruct.append("Shapes:\n");

      for (AShape shape : shapeList) {
        instruct.append(shape.printShape());
      }

      for (ACommand command : actionList) {
        instruct.append(command.printCommand());
      }

      return instruct.toString();
    }
  }

  /**
   * Checks for overlapping commands in the entire list of commands.
   */

  private boolean badCommands(List<ACommand> actionList) {
    for (int i = 0; i < actionList.size(); i++) {
      int sameCount = 0;
      for (ACommand command : actionList) {
        if (similarCommand(actionList.get(i), command)) {
          sameCount++;
        }
      }
      if (sameCount > 1) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if two given commands are similar.
   */
  private boolean similarCommand(ACommand needle, ACommand haystack) {
    return haystack.getStartTime() >= needle.getStartTime() &&
            haystack.getEndTime() <= needle.getEndTime() &&
            haystack.getClass() == needle.getClass();
  }
}

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
  private List<ACommand> commandList;

  /**
   * This is the interface of the Animator Model. It defines the behavior of the model.
   */

  public AnimatorModel() {
    shapeList = new ArrayList<>();
    commandList = new ArrayList<>();
  }

  @Override
  public void startAnimation(List<AShape> shapeList, List<ACommand> actionList) {
    this.shapeList = shapeList;
    this.commandList = actionList;

    // sorts action list by startingTime
    actionList.sort(Comparator.comparingInt(ACommand::getStartTime));

    if (badCommands(actionList)) {
      throw new IllegalArgumentException("Cannot have two of the same commands " +
              "happening at the same time on the same shape.");
    }
  }

  @Override
  public void move(ACommand curCommand, int curTime) {
    curCommand.command(curCommand.getShape(), curTime);
  }

  @Override
  public void addShape(String name, AShape.ShapeType type, double x, double y, Color color,
                       int timeAppear, int timeDisappear, double xSize, double ySize) {
    switch (type) {
      case OVAL:
        shapeList.add(new OvalShape(x, y, color, name, timeAppear, timeDisappear,
                xSize, ySize));
        break;
      case RECTANGLE: shapeList.add(new RectangleShape(x, y, color, name, timeAppear, timeDisappear,
              xSize, ySize));
        break;
      default: throw new IllegalArgumentException("not a valid type");
    }
  }

  @Override
  public void addScaleCommand(String shapeName, int startTime, int endTime, double x, double y) {
    AShape getShape = findShape(shapeName);

    commandList.add(new ScaleCommand(getShape, startTime, endTime, x, y));
  }

  @Override
  public void addChangeCommand(String shapeName, int startTime, int endTime, Color color) {
    AShape getShape = findShape(shapeName);

    commandList.add(new ChangeCommand(getShape, startTime, endTime, color));
  }

  @Override
  public void addMoveCommand(String shapeName, int startTime, int endTime, double x, double y) {
    AShape getShape = findShape(shapeName);

    commandList.add(new ScaleCommand(getShape, startTime, endTime, x, y));
  }

  @Override
  public String printInstructions() {
    if (commandList.isEmpty() && shapeList.isEmpty()) {
      return "";
    } else {
      StringBuilder instruct = new StringBuilder();

      instruct.append("Shapes:\n");

      for (AShape shape : shapeList) {
        instruct.append(shape.printShape());
      }

      for (ACommand command : commandList) {
        instruct.append(command.printCommand());
      }

      return instruct.toString();
    }
  }

  public List<AShape> getShapeList() {
    return this.shapeList;
  }

  public List<ACommand> getCommandList() {
    return this.commandList;
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
   * Finds the shape in the list with the same name as the input.
   */
  private AShape findShape(String shapeName) {
    AShape getShape = null;
    for (AShape shape : shapeList) {
      if (shape.getName().equals(shapeName)) {
        getShape = shape;
        break;
      }
    }
    if (getShape == null) {
      throw new IllegalArgumentException("shape not found");
    }
    return getShape;
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

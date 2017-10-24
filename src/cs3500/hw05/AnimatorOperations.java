package cs3500.hw05;

import java.util.List;
import java.awt.Color;
import cs3500.hw05.AShape.ShapeType;

/**
 * This is the interface of the Animator Model. It defines the behavior of the model. I chose
 * this implementation because I felt it would scale well and because it was easy to implement.
 * It's also very easy to use.
 */

public interface AnimatorOperations {

  /**
   * This method prints out the instructions given to the model.
   */
  String printInstructions();

  /**
   * This method starts the animation and runs all the given commands on the given shapes with
   * the given time multiplier. The model will not actually run the commands or display the
   * animation.
   * @param shapeList        list of shapes to be shown
   * @param actionList       list of actions to be performed on the shapes
   * @param timeMultiplier   int for speeding up animation
   */
  void startAnimation(List<AShape> shapeList, List<ACommand> actionList, int timeMultiplier);

  /**
   * This method will eventually be called by the controller to perform a command on a certain
   * shape. It must be here for the Controller to have any effect on the actual shapes in the
   * model.
   * @param curCommand   command to be performed
   * @param curTime   current time of the animation
   */
  void move(ACommand curCommand, int curTime);

  /**
   * This method makes a new shape from the given parameters and adds it to the list.
   * @param name   shape to be added to the list
   * @param type   type of shape
   * @param x      x position
   * @param y      y position
   * @param color  color of the shape
   * @param timeAppear   time appear
   * @param timeDisappear   time disappear
   * @param xSize   x size
   * @param ySize   y size
   */
  void addShape(String name, AShape.ShapeType type, int x, int y, Color color, int timeAppear,
                int timeDisappear, int xSize, int ySize);

  /**
   * This method will eventually be called by the controller to perform a command on a certain
   * shape. It must be here for the Controller to have any effect on the actual shapes in the
   * model.
   * @param name   shape to be removed
   */
  void removeShape(String name);

  /**
   * This method makes a new command from the given parameters and adds it to the list.
   * @param name   name of the shape to perform on
   */
  void addCommand(String name);

  /**
   * This method will eventually be called by the controller to perform a command on a certain
   * shape. It must be here for the Controller to have any effect on the actual shapes in the
   * model.
   */
  void removeCommand(String name);
}

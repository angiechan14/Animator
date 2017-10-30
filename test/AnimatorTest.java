import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;

import cs3500.hw05.model.ACommand;
import cs3500.hw05.model.AShape;
import cs3500.hw05.model.AnimatorModel;
import cs3500.hw05.model.AnimatorOperations;
import cs3500.hw05.model.ChangeCommand;
import cs3500.hw05.model.MoveCommand;
import cs3500.hw05.model.OvalShape;
import cs3500.hw05.model.RectangleShape;
import cs3500.hw05.model.ScaleCommand;

import static org.junit.Assert.assertEquals;

/** Tests for Animator Model.
 */
public class AnimatorTest {

  private AnimatorOperations model = new AnimatorModel();
  private AShape circle = new OvalShape(5.0, 6.0, new Color(200, 2, 3), "O",
          0, 50, 60.0, 30.0);

  private AShape rect = new RectangleShape(5.0, 20.0, new Color(63, 200, 113), "R",
          10, 50, 50.0, 20.0);

  private ArrayList<AShape> shapeList = new ArrayList<>();

  private ACommand move = new MoveCommand(rect, 5, 10,1.0, 2.0);
  private ACommand scale = new ScaleCommand(circle, 10, 15, 50.0, 30.0);
  private ACommand change = new ChangeCommand(rect, 25, 30,
           new Color(5, 5, 5));

  private ArrayList<ACommand> commands = new ArrayList<>();

  /** Setup model data for the tests.
   */
  @Before
  public void setupTest() {
    shapeList.add(circle);
    shapeList.add(rect);

    commands.add(move);
    commands.add(change);
    commands.add(scale);

  }

  @Test
  // tests that the instructions print correctly
  public void checkInstruct() {
    model.startAnimation(shapeList, commands);
    assertEquals(model.printInstructions(), "Shapes:\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (5.0,6.0), X radius: 60.0 Y radius: 30.0, Color: [r=200,g=2,b=3]\n" +
            "Appears at t=0\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Lower-left corner: (5.0,20.0), Width: 50.0 Height: 20.0, Color: [r=63,g=200,b=113]\n" +
            "Appears at t=10\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape R moves from (5.0,20.0) to (1.0,2.0) from t=5 to t=10\n" +
            "Shape O scales from (60.0,30.0) to (50.0,30.0) from t=10 to t=15\n" +
            "Shape R changes color from [r=63,g=200,b=113] to [r=5,g=5,b=5] from t=25 to t=30\n");
  }

  @Test
  // empty test for print Instructions
  public void checkInstruct2() {
    assertEquals(model.printInstructions(), "");
  }

  @Test
  // test for move with scale and a givne time
  public void moveTest() {
    model.startAnimation(shapeList, commands);
    model.move(scale, 15);
    assertEquals(circle.getXSize() == 50.0, true);
  }

  @Test (expected = IllegalArgumentException.class)
  // tests that the model throws an error when there are incorrect commands
  public void checkBadList() {
    commands.add(new MoveCommand(rect, 8, 9,   1.5,  9.0));
    model.startAnimation(shapeList, commands);
  }

  @Test
  // tests that the model doesn't throw an error when given correct commands
  public void checkBadList2() {
    commands.add(new MoveCommand(rect, 26, 29,  1.5, 9.0));
    model.startAnimation(shapeList, commands);

    assertEquals(model.printInstructions(), "Shapes:\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Center: (5.0,6.0), X radius: 60.0 Y radius: 30.0, Color: [r=200,g=2,b=3]\n" +
            "Appears at t=0\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Lower-left corner: (5.0,20.0), Width: 50.0 Height: 20.0, Color: [r=63,g=200,b=113]\n" +
            "Appears at t=10\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape R moves from (5.0,20.0) to (1.0,2.0) from t=5 to t=10\n" +
            "Shape O scales from (60.0,30.0) to (50.0,30.0) from t=10 to t=15\n" +
            "Shape R changes color from [r=63,g=200,b=113] to [r=5,g=5,b=5] from t=25 to t=30\n" +
            "Shape R moves from (5.0,20.0) to (1.5,9.0) from t=26 to t=29\n");
  }

}

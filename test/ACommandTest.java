import org.junit.Test;

import java.awt.Color;

import cs3500.animator.model.ACommand;
import cs3500.animator.model.AShape;
import cs3500.animator.model.ChangeCommand;
import cs3500.animator.model.MoveCommand;
import cs3500.animator.model.OvalShape;
import cs3500.animator.model.RectangleShape;
import cs3500.animator.model.ScaleCommand;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Commands.
 */
public class ACommandTest {
  private AShape circle = new OvalShape(5.0, 6.0, new Color(200, 2, 3), "O",
          0, 50, 60.0, 30.0);

  private AShape rect = new RectangleShape(5.0, 20.0, new Color(63, 200, 113), "R",
          10, 50, 50.0, 20.0);

  private ACommand move = new MoveCommand(rect, 5, 10,1.0, 2.0);
  private ACommand scale = new ScaleCommand(circle, 10, 15,50.0, 30.0);
  private ACommand change = new ChangeCommand(rect, 25, 30, new Color(5, 5, 5));


  @Test
  // checks start time
  public void getStartTime() throws Exception {
    assertEquals(move.getStartTime(), 5);
  }

  @Test
  // checks end time
  public void getEndTime() throws Exception {
    assertEquals(scale.getEndTime(), 15);
  }

  @Test
  // check print command for a command
  public void printCommand() throws Exception {
    assertEquals(change.printCommand(), "Shape R changes color from [r=63,g=200,b=113] "
            + "to [r=5,g=5,b=5] from t=25 to t=30\n");
  }

  @Test
  // check what the given command renders to as a string (move)
  public void getMove() throws Exception {
    assertEquals(move.getMove(circle), "moves from (5.0,6.0) to (1.0,2.0) ");
  }

  @Test
  // check what the given command renders to as a string (scale)
  public void getMove2() throws Exception {
    assertEquals(scale.getMove(circle), "scales from (60.0,30.0) to (50.0,30.0) ");
  }

  @Test
  // check what the given command renders to as a string (recolor)
  public void getMove3() throws Exception {
    assertEquals(change.getMove(circle), "changes color from [r=200,g=2,b=3] "
            + "to [r=5,g=5,b=5] ");
  }

  @Test
  // check that the given command works correctly (scale)
  public void scaleTest() {
    scale.command(circle, 15);
    assertEquals(circle.getXSize() == 50.0, true);
  }

  @Test
  // check that the given command works correctly (scale)
  public void scaleTest2() {
    scale.command(circle, 10);
    assertEquals(circle.getXSize() == 98.0, true);
  }

  @Test
  // check that the given command works correctly (move)
  public void moveTest() {
    move.command(rect, 10);
    assertEquals(rect.getX() == 1.0, true);
  }

  @Test
  // check that the given command works correctly (move)
  public void moveTest2() {
    move.command(rect, 8);
    assertEquals(rect.getX() == 4.2, true);
  }

  @Test
  // check that the given command works correctly (recolor)
  public void changeTest() {
    change.command(rect, 30);
    assertEquals(rect.getColor(), new Color(5, 5, 5));
  }

  @Test
  // check that the given command works correctly (recolor)
  public void changeTest2() {
    change.command(rect, 26);
    assertEquals(rect.getColor(), new Color(52, 161, 92));
  }

  @Test
  // check that the given command works correctly (scale)
  public void scaleTest3() {
    scale.command(rect, 15);
    assertEquals(rect.getXSize() == 50.0, true);
  }

}
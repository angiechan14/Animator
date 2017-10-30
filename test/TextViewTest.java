import org.junit.Before;
import org.junit.Test;

import java.awt.*;
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
import cs3500.hw05.view.IView;
import cs3500.hw05.view.TextView;

import static org.junit.Assert.*;



public class TextViewTest {

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

  private IView textView = new TextView(model, 2, System.out);


  /** Setup model data for the tests.
   */
  @Before
  public void setupTest() {
    shapeList.add(circle);
    shapeList.add(rect);
    commands.add(change);
    commands.add(scale);
    commands.add(move);
  }

  @Test
  public void display() throws Exception {

    model.startAnimation(shapeList, commands);

    textView.display();
  }

}
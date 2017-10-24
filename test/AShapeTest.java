import org.junit.Test;

import java.awt.Color;

import cs3500.hw05.AShape;
import cs3500.hw05.OvalShape;
import cs3500.hw05.RectangleShape;

import static org.junit.Assert.assertEquals;

/** Tests for AShape.
 */
public class AShapeTest {
  private AShape circle = new OvalShape(5.0, 6.0, new Color(200, 2, 3), "O",
          0, 50, 60.0, 30.0);

  private AShape rect = new RectangleShape(5.0, 20.0, new Color(63, 200, 113), "R",
          10, 50, 50.0, 20.0);

  @Test
  public void moveTest() {
    circle.move(2.0, 3.0);

    assertEquals(circle.getX() == 2.0, true);
  }

  @Test
  public void recolor() {
    Color newC = new Color(60, 60, 60);
    rect.recolor(newC);

    assertEquals(rect.getColor(), new Color(60, 60, 60));
  }

  @Test
  public void getNameTest() throws Exception {
    assertEquals(rect.getName(), "R");
  }

  @Test
  public void getXTest() throws Exception {
    assertEquals(circle.getX() == 5.0, true);
  }

  @Test
  public void getYTest() throws Exception {
    assertEquals(rect.getY() == 20.0, true);
  }

  @Test
  public void getXSizeTest() throws Exception {
    assertEquals(circle.getXSize() == 60.0, true);
  }

  @Test
  public void getYSizeTest() throws Exception {
    assertEquals(rect.getYSize() == 20.0, true);
  }


  @Test
  public void resizeTest() throws Exception {
    rect.resize(20.0, 30.0);
    assertEquals(rect.getYSize() == 30.0, true);
  }

}
package cs3500.hw05.model;

import java.awt.Color;

/** Abstract class for defining behavior common to all shapes.
 * I chose to make the Shape abstract because different shapes share some functionality but also
 * have different functionality. It saves on duplicated code. It's also easy to add new shapes and
 * functionality.
 */
public abstract class AShape {
  private double x;
  private double y;
  private Color color;
  private String name;
  private int timeAppear;
  private int timeRemove;

  /** Constructor for AShape that keeps all of the common parts of the shape.
   */
  public AShape(double x, double y, Color color, String name, int timeAppear, int timeRemove) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.name = name;
    this.timeAppear = timeAppear;
    this.timeRemove = timeRemove;
  }

  /** Mutates the given shape by replacing the old x and y positions with new ones.
   */
  public void move(double newX, double newY) {
    x = newX;
    y = newY;
  }

  /** Mutates the given shape by changing the old color to the new one.
   */
  public void recolor(Color newC) {

    this.color = newC;
  }

  /** Gets the X of this shape.
   */
  public double getX() {
    return x;
  }

  /** Gets the Y of this shape.
   */
  public double getY() {
    return y;
  }

  /** Gets the Color of this shape.
   */
  public Color getColor() {
    return color;
  }

  /** Gets the time remove of this shape.
   */
  int getTimeRemove() {
    return timeRemove;
  }

  /** Returns the String version of all the important information about the String.
   */
  public String printShape() {
    return "Name: " +
            name +
            "\n" +
            "Type: " +
            this.getPrint() +
            ", Color: " +
            color.toString().substring(14) +
            "\n" +
            "Appears at t=" +
            String.valueOf(timeAppear) +
            "\n" +
            "Disappears at t=" +
            String.valueOf(timeRemove) +
            "\n\n";
  }

  /** Returns the String version of all the important information about the String.
   */
  public String printShape(double time) {
    return "Name: " +
            name +
            "\n" +
            "Type: " +
            this.getPrint() +
            ", Color: " +
            color.toString().substring(14) +
            "\n" +
            "Appears at t=" +
            String.valueOf(timeAppear / time) +
            "\n" +
            "Disappears at t=" +
            String.valueOf(timeRemove / time) +
            "\n\n";
  }

  /** Formats the location of this x and y.
   */
  String formatLocation() {
    return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
  }

  /** Gets the name of this shape.
   */
  public String getName() {
    return name;
  }

  String getColorString() {
    return color.toString().substring(14);
  }

  /** Gets the XSize of this shape given if its Rectangle or Oval.
   */
  public abstract double getXSize();

  /** Gets the YSize of this shape given if its Rectangle or Oval.
   */
  public abstract double getYSize();

  /** Gets the shape String given either Rectangle or Oval.
   */
  abstract String getPrint();

  /** Resizes the given shape if its Rectangle or Oval.
   */
  public abstract void resize(double newWidth, double newHeight);

  public enum ShapeType {
    OVAL, RECTANGLE
  }

}

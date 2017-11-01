package cs3500.animator.view;

import java.io.OutputStream;
import java.util.List;

import cs3500.animator.model.ACommand;
import cs3500.animator.model.AShape;

public class SVGView implements IView {
  private int timeMultiplier;
  private OutputStream out;
  private List<AShape> shapeList;
  private List<ACommand> commandList;

  public SVGView(int timeMultiplier, OutputStream out, List<AShape> shapeList,
                  List<ACommand> commandList) {
    this.timeMultiplier = timeMultiplier;
    this.out = out;
    this.shapeList = shapeList;
    this.commandList = commandList;
  }

  @Override
  public void display() {

    if (commandList.isEmpty() && shapeList.isEmpty()) {
      System.out.println("");
    } else {
      StringBuilder instruct = new StringBuilder();

      instruct.append("<svg width=\"700\" height=\"500\" version=\"1.1\"\n" +
              "     xmlns=\"http://www.w3.org/2000/svg\">\n" +
              "<rect>\n" +
              "   <animate id=\"base\" begin=\"0;base.end\" dur=\"10000.0ms\" attributeName=\"" +
              "visibility\" from=\"hide\" to=\"hide\"/>\n" +
              "</rect>");

      for (AShape shape : shapeList) {
        instruct.append(shape.svgShape());
        for (ACommand command : commandList) {
          if (command.getShape().equals(shape)) {
            instruct.append(command.svgCommand());
          }
        }
        instruct.append(shape.svgEnd());
      }

      System.out.println(instruct.toString());
    }
  }

  @Override
  public void refresh() {

  }
}

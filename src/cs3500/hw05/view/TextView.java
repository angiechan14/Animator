package cs3500.hw05.view;

import java.io.OutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import cs3500.hw05.model.ACommand;
import cs3500.hw05.model.AShape;
import cs3500.hw05.model.AnimatorOperations;

public class TextView implements IView {
  private int timeMultiplier;
  private OutputStream out;
  private List<AShape> shapeList;
  private List<ACommand> commandList;

  public TextView(int timeMultiplier, OutputStream out, List<AShape> shapeList,
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

      instruct.append("Shapes:\n");

      for (AShape shape : shapeList) {
        instruct.append(shape.printShape(timeMultiplier));
      }

      for (ACommand command : commandList) {
        instruct.append(command.printCommand(timeMultiplier));
      }

      System.out.println(instruct.toString());
    }
  }
}

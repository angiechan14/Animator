package cs3500.hw05.view;

import java.io.OutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import cs3500.hw05.model.ACommand;
import cs3500.hw05.model.AShape;
import cs3500.hw05.model.AnimatorOperations;

public class TextView implements IView {
  private AnimatorOperations model;
  private int timeMultiplier;
  private OutputStream out;

  public TextView(AnimatorOperations model, int timeMultiplier, OutputStream out) {
    this.model = model;
    this.timeMultiplier = timeMultiplier;
    this.out = out;
  }

  @Override
  public void display() {

    if (model.getCommandList().isEmpty() && model.getShapeList().isEmpty()) {
      System.out.println("");
    } else {
      StringBuilder instruct = new StringBuilder();

      instruct.append("Shapes:\n");

      for (AShape shape : model.getShapeList()) {
        instruct.append(shape.printShape(timeMultiplier));
      }

      for (ACommand command : model.getCommandList()) {
        instruct.append(command.printCommand(timeMultiplier));
      }

      System.out.println(instruct.toString());
    }
  }
}

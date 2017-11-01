package cs3500.hw05.view;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.util.function.Consumer;


import javax.swing.*;

public class VisualView extends JFrame implements IView {
  private JButton commandButton,quitButton;
  private JPanel buttonPanel;
  private JPanel animatorPanel;
  private JScrollPane scrollPane;
  private JTextField input;
  private Consumer<String> commandCallback;


  public VisualView() {
    super();

    this.setTitle("Animator");
    this.setSize(500,500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    animatorPanel = new JPanel();
    animatorPanel.setPreferredSize(new Dimension(500,500));
    scrollPane = new JScrollPane(animatorPanel);
    this.add(scrollPane,BorderLayout.CENTER);

    //button panel
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel,BorderLayout.SOUTH);

    //input textfield
    input = new JTextField(15);
    buttonPanel.add(input);

    //buttons
    commandButton = new JButton("Execute");
    commandButton.addActionListener((ActionEvent e) ->
    {
      if (commandCallback!=null) { //if there is a command callback
        commandCallback.accept(input.getText()); //send command to be processed
        input.setText(""); //clear the input text field
      }
    });
    buttonPanel.add(commandButton);

    //quit button
    quitButton = new JButton("Quit");
    quitButton.addActionListener((ActionEvent e)-> {System.exit(0);});
    buttonPanel.add(quitButton);

    commandCallback = null;

    this.pack();

  }

  @Override
  public void display() {

  }
}

package cs3500.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.util.List;
import cs3500.animator.model.AShape;

import javax.swing.*;

public class VisualView extends JFrame implements IView {
  private JButton quitButton;
  private JPanel animatorPanel;
  private JScrollPane scrollPane;
  private List<AShape> shapes;
  private JPanel buttonPanel;

  public VisualView(List<AShape> shapes) {
    super();

    this.shapes = shapes;
    this.animatorPanel = new JPanel();
    this.setTitle("Animator");
    this.setSize(600,600);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    animatorPanel.setPreferredSize(new Dimension(500,500));

    for (AShape shape : this.shapes) {
      animatorPanel.add(new ShapePanel(shape));
    }

    scrollPane = new JScrollPane(animatorPanel);
    this.add(scrollPane,BorderLayout.CENTER);

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel,BorderLayout.SOUTH);

    //quit button
    quitButton = new JButton("Quit");
    quitButton.addActionListener((ActionEvent e)-> {System.exit(0);});
    buttonPanel.add(quitButton);


    this.pack();

  }

  @Override
  public void display() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }
}

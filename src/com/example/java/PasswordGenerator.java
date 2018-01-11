package com.example.java;

import javax.swing.*;

public class PasswordGenerator extends JFrame {

   private JFrame mainFrame;
   private JPanel mainPanel;
   private JButton generate;
   private JSpinner passLength;
   private JCheckBox lower, upper, numbers;
   private JLabel pLength;
   private Box option;


    public PasswordGenerator() {
        mainFrame = new JFrame();
        mainFrame.setSize(300,200);
        mainFrame.setMinimumSize(this.getSize());
        mainFrame.setMaximumSize(this.getSize());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Password generator");

        mainPanel = new JPanel();
        generate = new JButton("Generate");
        GeneratePasswordListener buttonListener = new GeneratePasswordListener(this);
        generate.addActionListener(buttonListener);

        pLength = new JLabel();
        pLength.setText("Choose password length: ");
        passLength = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        Box length = Box.createHorizontalBox();
        length.add(pLength);
        length.add(passLength);


        lower = new JCheckBox("Lower");
        upper = new JCheckBox("Upper");
        numbers = new JCheckBox("Numbers");

        option = Box.createHorizontalBox();
        option.add(lower);
        option.add(upper);
        option.add(numbers);

        mainPanel.add(length);
        mainPanel.add(option);
        mainPanel.add(generate);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

    }


    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JButton getGenerate() {
        return generate;
    }

    public JSpinner getPassLength() {
        return passLength;
    }

    public JCheckBox getLower() {
        return lower;
    }

    public JCheckBox getUpper() {
        return upper;
    }

    public JCheckBox getNumbers() {
        return numbers;
    }
}

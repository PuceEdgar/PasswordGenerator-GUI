package com.example.java;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class GeneratePasswordListener implements ActionListener {

    private PasswordGenerator passwordGenerator;
    private SecureRandom secureRandom;
    private StringBuilder pass;
    private String passType = "";
    private String lower = PasswordValues.getLOWER();
    private String upper = PasswordValues.getUPPER();
    private String numbers = PasswordValues.getNUMBERS();

    public GeneratePasswordListener(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        secureRandom = new SecureRandom();
        if (e.getSource() == passwordGenerator.getGenerate()) {
            if (lowerSelected() && upperSelected() && numbersSelected()) {
                passType += lower + upper + numbers;
                generatePassword();
            } else if (upperSelected() && numbersSelected()) {
                passType += upper + numbers;
                generatePassword();
            } else if (lowerSelected() && numbersSelected()) {
                passType += lower + numbers;
                generatePassword();
            } else if (lowerSelected() && upperSelected()) {
                passType += lower + upper;
                generatePassword();
            } else if (lowerSelected()) {
                passType += lower;
                generatePassword();
            } else if (upperSelected()) {
                passType += upper;
                generatePassword();
            } else if (numbersSelected()) {
                passType += numbers;
                generatePassword();
            }

             if (passType.length() == 0)  {
                JOptionPane.showMessageDialog(
                        passwordGenerator.getMainFrame(),
                        "Please choose at least 1 option!",
                        "ERROR!",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                 JOptionPane.showMessageDialog(
                         passwordGenerator.getMainFrame(),
                         pass,
                         "New Password",
                         JOptionPane.INFORMATION_MESSAGE);
                 pass.delete(0, passType.length());
             }

        }

        passType = "";
    }


    private void generatePassword(){
        String passL = passwordGenerator.getPassLength().getValue().toString();
        int passLength = Integer.parseInt(passL);
        pass = new StringBuilder();
        for (int i = 0; i < passLength; i++) {
            pass.append(passType.charAt(secureRandom.nextInt(passType.length())));
        }
    }

    private boolean lowerSelected() {
        return passwordGenerator.getLower().isSelected();
    }

    private boolean upperSelected() {
       return passwordGenerator.getUpper().isSelected();
    }

    private boolean numbersSelected() {
        return passwordGenerator.getNumbers().isSelected();
    }
}

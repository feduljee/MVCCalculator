package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCalculateListener(new CalculatorListener());
    }

    class CalculatorListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            int firstNumber, secondNumber = 0;
            // Perform the calculation
            try {
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("You need to enter 2 integers");
                return;
            }
            theModel.addTwoNumbers(firstNumber, secondNumber);
            theView.setCalcSolution(theModel.getCalculationValue());
        }
    }

}

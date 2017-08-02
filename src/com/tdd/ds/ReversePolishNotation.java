package com.tdd.ds;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(final String[] args) {
        final ReversePolishNotation s = new ReversePolishNotation();
        System.out.println(s.calculateFromReversePolishNotation("3 4 +"));
        System.out.println(s.calculateFromReversePolishNotation("3 4 - 5 +"));
        System.out.println(s.calculateFromReversePolishNotation("3 4 5 * -"));
//        System.out.println(s.calculateFromReversePolishNotation("3 4 * -"));
//        System.out.println(s.calculateFromReversePolishNotation("3 4 {"));
    }

    private int calculateFromReversePolishNotation(final String reversePolishStr) {
        final Stack<Integer> calculator = new Stack<>();
        for (String unit : reversePolishStr.split("\\s")) {
            if (!unitIsMathematicalOperator(unit) && unitNotANumber(unit))
                throwException("unit not recognized");
            if (unitIsMathematicalOperator(unit)) {
                calculateIntermediateOperationAndPushToStack(unit, calculator);
            } else {
                pushToStack(unit, calculator);
            }
        }
        if (calculator.isEmpty())
            return throwException("invalid input");

        return calculator.pop();
    }


    private void calculateIntermediateOperationAndPushToStack(final String unit, final Stack<Integer> calculator) {
        final String trimmedUnit = unit.trim();
        if (calculator.size() < 2)
            throwException("invalid input");

        final int operand2 = calculator.pop();
        final int operand1 = calculator.pop();

        switch (trimmedUnit) {
            case "+":
                calculator.push(operand1 + operand2);
                break;
            case "-":
                calculator.push(operand1 - operand2);
                break;
            case "/":
                calculator.push(operand1 / operand2);
                break;
            case "*":
                calculator.push(operand1 * operand2);
                break;
            default:
                throwException("operator not recognized");
        }
    }

    private void pushToStack(final String unit, final Stack<Integer> calculator) {
        calculator.push(Integer.parseInt(unit.trim()));
    }

    private boolean unitIsMathematicalOperator(final String unit) {
        final String trimmedUnit = unit.trim();
        if ("+".equals(trimmedUnit) || "-".equals(trimmedUnit) || "/".equals(trimmedUnit) || "*".equals(trimmedUnit))
            return true;
        return false;
    }

    private boolean unitNotANumber(final String unit) {
        try {
            Integer.parseInt(unit.trim());
        } catch (final NumberFormatException e) {
            return true;
        }
        return false;
    }

    private int throwException(final String message) {
        throw new IllegalArgumentException(message);
    }
}


package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public final class Calculator {


    private final StringBuilder textEquation ;

    public Calculator() {
        textEquation= new StringBuilder();
    }


    public void append(String numberOrOperator) {
        String loadedChar = new StringBuilder().append("").append(numberOrOperator).toString();
        textEquation.append(loadedChar);
    }
    public void clear() {
        textEquation.delete(0, textEquation.length());
    }
    public void clearLastSign(){

        if (textEquation.length() > 0) {
            textEquation.delete(textEquation.length() - 1, textEquation.length());
            }
    }



    public String calculateEquation() {
        String resultOfCalculation="";
        int lengthEquation = textEquation.length();
        if (lengthEquation < 1) {
            return resultOfCalculation;
        }
        double result;
        try {
            Expression expression = new ExpressionBuilder(textEquation.toString()).build();
            result = expression.evaluate();
        } catch (Exception e) {
            result = Double.NaN;
        }

         resultOfCalculation = Double.toString(result);
        return resultOfCalculation;
    }


    public StringBuilder getTextEquation()
    {
        return textEquation;
    }


}

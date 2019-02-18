package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.calculator.Calculator;


public class CalculatorTest {
    @Test
    public void calculatorPlusPlus() {

        Calculator calculator= new Calculator();
        calculator.append("2");
        calculator.append("*");
        calculator.append("2");
        assertEquals(calculator.calculateEquation(), "4.0");

        calculator.clear();
    }

    @Test
    public void calculatorDivideBy0() {

        Calculator calculator= new Calculator();
        calculator.append("2");
        calculator.append("/");
        calculator.append("0");
        assertEquals(calculator.calculateEquation(), "NaN");

        calculator.clear();
    }



}

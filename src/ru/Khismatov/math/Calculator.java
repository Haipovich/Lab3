package ru.Khismatov.math;

import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;

public class Calculator implements ICalculator {
    public static double calculate_power(String exp, String power) {return pow(parseInt(exp), parseInt(power));}

    @Override
    public double sum(Number... numbers){
        double sum = 0;
        for (Number number : numbers) {sum += number.doubleValue();}
        return sum;
    }
}

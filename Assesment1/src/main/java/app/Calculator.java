package app;

/**
 * Created by Alexandr on 30.04.2017.
 */
public class Calculator {

    public double calc(double firstNumber , double secondNumber, String operation) {

        if (operation.equals("Sum")) {
            double sum = firstNumber + secondNumber;
            return sum;
        } else if (operation.equals("Difference")) {
            double diff = firstNumber - secondNumber;
            return diff;
        } else if (operation.equals("Multiply")) {
            double mult = firstNumber * secondNumber;
            return mult;
        } else if (operation.equals("Division")) {
            double div = firstNumber / secondNumber;
            return div;
        } else
        return -1;
    }
    public static void main(String[] args) {

        Calculator calculator = new Calculator() ;
        System.out.println(calculator.calc(6,0,"Difference"));
        System.out.println(calculator.calc(2,4,"Division"));

    }
}

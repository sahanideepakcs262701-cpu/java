package question1;

abstract class Calculator {

    abstract void addition(int a, int b);
    abstract void subtraction(int a, int b);
    abstract void multiplication(int a, int b);
    abstract void division(int a, int b);
}

class Operations extends Calculator {

    @Override
    void addition(int a, int b) {
        System.out.println("Addition = " + (a + b));
    }

    @Override
    void subtraction(int a, int b) {
        System.out.println("Subtraction = " + (a - b));
    }

    @Override
    void multiplication(int a, int b) {
        System.out.println("Multiplication = " + (a * b));
    }

    @Override
    void division(int a, int b) {
        if (b != 0) {
            System.out.println("Division = " + (a / b));
        } else {
            System.out.println("Division by zero is not possible.");
        }
    }
}

public class Question1 {

    public static void main(String[] args) {

        Operations obj = new Operations();

        obj.addition(20, 10);
        obj.subtraction(20, 10);
        obj.multiplication(20, 10);
        obj.division(20, 10);
    }
}

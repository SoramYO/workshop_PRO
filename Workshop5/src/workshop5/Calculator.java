package workshop5;

public class Calculator {

    public double divide(int a, int b) throws ArithmeticException, NumberOutOfRangeException {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        checkRange(a);
        checkRange(b);

        return (double) a / b;
    }

    public int multiply(int a, int b) throws NumberOutOfRangeException {
        checkRange(a);
        checkRange(b);

        return a * b;
    }

    private void checkRange(int num) throws NumberOutOfRangeException {
        if (num < -1000 || num > 1000) {
            throw new NumberOutOfRangeException("Number is outside the computation");
        }
    }
}

class NumberOutOfRangeException extends Exception {

    public NumberOutOfRangeException(String message) {
        super(message);
    }
}

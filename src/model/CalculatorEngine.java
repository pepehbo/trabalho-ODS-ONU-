public class CalculatorEngine {
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public void setFirstNumber(double number) {
        this.firstNumber = number;
    }

    public void setSecondNumber(double number) {
        this.secondNumber = number;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void clear() {
        firstNumber = 0;
        secondNumber = 0;
        operator = null;
    }

    public double calculate() throws ArithmeticException {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "×" -> firstNumber * secondNumber;
            case "÷" -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield firstNumber / secondNumber;
            }
            case "^" -> Math.pow(firstNumber, secondNumber);
            default -> throw new ArithmeticException("Invalid operator");
        };
    }

    public double calculateSquareRoot(double number) throws ArithmeticException {
        if (number < 0) {
            throw new ArithmeticException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
}
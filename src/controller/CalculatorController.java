public class CalculatorController {
    private final CalculatorEngine engine;
    private boolean startNewNumber;

    public CalculatorController() {
        this.engine = new CalculatorEngine();
        this.startNewNumber = true;
    }

    public void handleNumber(int number, DisplayComponent display) {
        if (startNewNumber) {
            display.setValue(String.valueOf(number));
            startNewNumber = false;
        } else {
            display.setValue(display.getValue() + number);
        }
    }

    public void handleOperator(String operator, DisplayComponent display) {
        engine.setFirstNumber(Double.parseDouble(display.getValue()));
        engine.setOperator(operator);
        startNewNumber = true;
    }

    public void handleEquals(DisplayComponent display) {
        if (!startNewNumber) {
            try {
                engine.setSecondNumber(Double.parseDouble(display.getValue()));
                double result = engine.calculate();
                display.setValue(NumberFormatter.format(result));
            } catch (ArithmeticException e) {
                display.setValue("Error");
            }
            startNewNumber = true;
        }
    }

    public void handleSquareRoot(DisplayComponent display) {
        try {
            double number = Double.parseDouble(display.getValue());
            double result = engine.calculateSquareRoot(number);
            display.setValue(NumberFormatter.format(result));
            startNewNumber = true;
        } catch (ArithmeticException e) {
            display.setValue("Error");
        }
    }

    public void handleClear(DisplayComponent display) {
        display.setValue("0");
        engine.clear();
        startNewNumber = true;
    }

    public void handleDecimal(DisplayComponent display) {
        if (!display.getValue().contains(".")) {
            display.setValue(display.getValue() + ".");
            startNewNumber = false;
        }
    }
}
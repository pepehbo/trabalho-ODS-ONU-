import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
    private TextField display;
    private CalculatorEngine engine;
    private boolean startNewNumber = true;

    @Override
    public void start(Stage primaryStage) {
        engine = new CalculatorEngine();
        
        // Create the calculator UI
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #f0f0f0;");

        // Display field
        display = new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 24px; -fx-background-color: white;");

        // Button grid
        GridPane buttonGrid = createButtonGrid();

        root.getChildren().addAll(display, buttonGrid);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        // Create number buttons
        for (int i = 0; i < 10; i++) {
            final int number = i;
            Button button = createButton(String.valueOf(i), 
                "-fx-background-color: white; -fx-text-fill: black;");
            button.setOnAction(e -> handleNumber(number));
            grid.add(button, i % 3, (9 - i) / 3 + 1);
        }

        // Operator buttons
        Button addBtn = createButton("+", "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button subBtn = createButton("-", "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button mulBtn = createButton("×", "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button divBtn = createButton("÷", "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button powBtn = createButton("^", "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button sqrtBtn = createButton("√", "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Button equalsBtn = createButton("=", "-fx-background-color: #2196F3; -fx-text-fill: white;");
        Button clearBtn = createButton("C", "-fx-background-color: #f44336; -fx-text-fill: white;");
        Button decimalBtn = createButton(".", "-fx-background-color: white; -fx-text-fill: black;");

        addBtn.setOnAction(e -> handleOperator("+"));
        subBtn.setOnAction(e -> handleOperator("-"));
        mulBtn.setOnAction(e -> handleOperator("×"));
        divBtn.setOnAction(e -> handleOperator("÷"));
        powBtn.setOnAction(e -> handleOperator("^"));
        sqrtBtn.setOnAction(e -> handleSquareRoot());
        equalsBtn.setOnAction(e -> handleEquals());
        clearBtn.setOnAction(e -> handleClear());
        decimalBtn.setOnAction(e -> handleDecimal());

        // Add operator buttons to grid
        grid.add(clearBtn, 0, 0);
        grid.add(sqrtBtn, 1, 0);
        grid.add(powBtn, 2, 0);
        grid.add(divBtn, 3, 0);
        grid.add(mulBtn, 3, 1);
        grid.add(subBtn, 3, 2);
        grid.add(addBtn, 3, 3);
        grid.add(decimalBtn, 2, 4);
        grid.add(equalsBtn, 3, 4);

        return grid;
    }

    private Button createButton(String text, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setPrefSize(50, 50);
        return button;
    }

    private void handleNumber(int number) {
        if (startNewNumber) {
            display.setText(String.valueOf(number));
            startNewNumber = false;
        } else {
            display.setText(display.getText() + number);
        }
    }

    private void handleOperator(String operator) {
        engine.setFirstNumber(Double.parseDouble(display.getText()));
        engine.setOperator(operator);
        startNewNumber = true;
    }

    private void handleEquals() {
        if (!startNewNumber) {
            engine.setSecondNumber(Double.parseDouble(display.getText()));
            try {
                double result = engine.calculate();
                display.setText(formatResult(result));
            } catch (ArithmeticException e) {
                display.setText("Error");
            }
            startNewNumber = true;
        }
    }

    private void handleSquareRoot() {
        try {
            double number = Double.parseDouble(display.getText());
            double result = engine.calculateSquareRoot(number);
            display.setText(formatResult(result));
            startNewNumber = true;
        } catch (ArithmeticException e) {
            display.setText("Error");
        }
    }

    private void handleClear() {
        display.setText("0");
        engine.clear();
        startNewNumber = true;
    }

    private void handleDecimal() {
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
            startNewNumber = false;
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        }
        return String.format("%.8f", result).replaceAll("0*$", "").replaceAll("\\.$", "");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
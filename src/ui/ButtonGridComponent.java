import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ButtonGridComponent {
    private final GridPane grid;
    private final CalculatorController controller;
    private final DisplayComponent display;

    public ButtonGridComponent(CalculatorController controller, DisplayComponent display) {
        this.controller = controller;
        this.display = display;
        this.grid = new GridPane();
        initializeGrid();
    }

    private void initializeGrid() {
        grid.setHgap(5);
        grid.setVgap(5);

        createNumberButtons();
        createOperatorButtons();
    }

    private void createNumberButtons() {
        for (int i = 0; i < 10; i++) {
            final int number = i;
            Button button = createButton(String.valueOf(i), ButtonStyle.NUMBER);
            button.setOnAction(e -> controller.handleNumber(number, display));
            grid.add(button, i % 3, (9 - i) / 3 + 1);
        }
    }

    private void createOperatorButtons() {
        addOperatorButton("+", 3, 3, ButtonStyle.OPERATOR);
        addOperatorButton("-", 3, 2, ButtonStyle.OPERATOR);
        addOperatorButton("×", 3, 1, ButtonStyle.OPERATOR);
        addOperatorButton("÷", 3, 0, ButtonStyle.OPERATOR);
        addOperatorButton("^", 2, 0, ButtonStyle.OPERATOR);
        addOperatorButton("√", 1, 0, ButtonStyle.OPERATOR);
        addOperatorButton("=", 3, 4, ButtonStyle.EQUALS);
        addOperatorButton("C", 0, 0, ButtonStyle.CLEAR);
        addOperatorButton(".", 2, 4, ButtonStyle.NUMBER);
    }

    private void addOperatorButton(String text, int col, int row, ButtonStyle style) {
        Button button = createButton(text, style);
        switch (text) {
            case "=" -> button.setOnAction(e -> controller.handleEquals(display));
            case "C" -> button.setOnAction(e -> controller.handleClear(display));
            case "." -> button.setOnAction(e -> controller.handleDecimal(display));
            case "√" -> button.setOnAction(e -> controller.handleSquareRoot(display));
            default -> button.setOnAction(e -> controller.handleOperator(text, display));
        }
        grid.add(button, col, row);
    }

    private Button createButton(String text, ButtonStyle style) {
        Button button = new Button(text);
        button.setStyle(style.getStyle());
        button.setPrefSize(50, 50);
        return button;
    }

    public Node getNode() {
        return grid;
    }
}
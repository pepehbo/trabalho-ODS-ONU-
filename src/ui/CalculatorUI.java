import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorUI extends Application {
    private final DisplayComponent display;
    private final ButtonGridComponent buttonGrid;
    private final CalculatorController controller;

    public CalculatorUI() {
        controller = new CalculatorController();
        display = new DisplayComponent();
        buttonGrid = new ButtonGridComponent(controller, display);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #f0f0f0;");

        root.getChildren().addAll(display.getNode(), buttonGrid.getNode());

        Scene scene = new Scene(root);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
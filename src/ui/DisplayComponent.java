import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

public class DisplayComponent {
    private final TextField display;

    public DisplayComponent() {
        display = new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 24px; -fx-background-color: white;");
    }

    public Node getNode() {
        return display;
    }

    public void setValue(String value) {
        display.setText(value);
    }

    public String getValue() {
        return display.getText();
    }
}
public enum ButtonStyle {
    NUMBER("-fx-background-color: white; -fx-text-fill: black;"),
    OPERATOR("-fx-background-color: #4CAF50; -fx-text-fill: white;"),
    EQUALS("-fx-background-color: #2196F3; -fx-text-fill: white;"),
    CLEAR("-fx-background-color: #f44336; -fx-text-fill: white;");

    private final String style;

    ButtonStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
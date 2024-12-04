public class NumberFormatter {
    public static String format(double number) {
        if (number == (long) number) {
            return String.format("%d", (long) number);
        }
        return String.format("%.8f", number)
            .replaceAll("0*$", "")
            .replaceAll("\\.$", "");
    }
}
package body;

public enum Colors {
    NORMAL("\u001B[0m"),
    GREEN("\u001B[32m"),
    RED("\u001B[31m"),
    YELLOW("\u001B[33m");

    private String color;

    Colors(String color) {
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static String errorString(String str) {
        return RED.getColor() + str + NORMAL.getColor();
    }

    public static String botString(String str) {
        return GREEN.getColor() + str + NORMAL.getColor();
    }
}

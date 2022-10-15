package Setting;

import java.awt.*;

/**
 * @author dj
 * @version 1.0
 **/

public class ColorToNumber {
    private Color color;
    private int number;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ColorToNumber(Color color, int number) {
        this.color = color;
        this.number = number;
    }
}

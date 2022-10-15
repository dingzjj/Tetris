package Setting;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;

/**
 * @author dj
 * @version 1.0
 **/

public class TetrisToColor {
    private char type;
    public static HashMap<Character,ColorToNumber> colors = new HashMap();
    public static Color I_COLOR = Color.BLUE;
    public static Color J_COLOR = Color.ORANGE;
    public static Color L_COLOR = Color.black;
    public static Color O_COLOR = Color.CYAN;
    public static Color S_COLOR = Color.RED;
    public static Color T_COLOR = Color.MAGENTA;
    public static Color Z_COLOR = Color.pink;
    static {
        // I ->1
        final ColorToNumber colorToNumber_I = new ColorToNumber(Color.BLUE, 1);
        colors.put('I',colorToNumber_I);
        // J ->2
        final ColorToNumber colorToNumber_J = new ColorToNumber(Color.ORANGE, 2);
        colors.put('J',colorToNumber_J);
        // L ->3
        final ColorToNumber colorToNumber_L = new ColorToNumber(Color.black, 3);
        colors.put('L',colorToNumber_L);
        // O ->4
        final ColorToNumber colorToNumber_O = new ColorToNumber(Color.CYAN, 4);
        colors.put('O',colorToNumber_O);
        // S ->5
        final ColorToNumber colorToNumber_S = new ColorToNumber(Color.RED, 5);
        colors.put('S',colorToNumber_S);
        // T ->6
        final ColorToNumber colorToNumber_T= new ColorToNumber(Color.MAGENTA, 6);
        colors.put('T',colorToNumber_T);
        // Z ->7
        final ColorToNumber colorToNumber_Z= new ColorToNumber(Color.pink, 7);
        colors.put('Z',colorToNumber_Z);
    }


}



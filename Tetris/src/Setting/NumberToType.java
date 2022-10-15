package Setting;

import java.util.HashMap;

/**
 * @author dj
 * @version 1.0
 **/

public class NumberToType {
    public static HashMap<Integer, Character> numberToType = new HashMap<>();

    static {
        // I ->1
        numberToType.put(1, 'I');
        // J ->2
        numberToType.put(2, 'J');
        // L ->3
        numberToType.put(3, 'L');
        // O ->4
        numberToType.put(4, 'O');
        //  S ->5
        numberToType.put(5, 'S');
        // T ->6
        numberToType.put(6, 'T');
        // Z ->7
        numberToType.put(7, 'Z');
    }
}

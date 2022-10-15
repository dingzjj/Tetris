package TetrisModel;

import java.awt.*;

/**
 * @author dj
 * @version 1.0
 **/

public class S_Tetromino extends Tetromino {

    public S_Tetromino(Color color, int state, char type) {
        super(color, state, type);
        Layout(state);
    }

    @Override
    public void Layout(int state) {
        if (state == STATE_1 || state == STATE_3) {
            layout = new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 1, 1, 0}};
        }
        if (state == STATE_2 || state == STATE_4) {
            layout = new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 1}};
        }

    }
}
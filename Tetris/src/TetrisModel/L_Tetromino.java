package TetrisModel;

import java.awt.*;

/**
 * @author dj
 * @version 1.0
 **/

public class L_Tetromino extends Tetromino{
    public L_Tetromino(Color color, int state, char type) {
        super(color, state, type);
        Layout(state);
    }

    @Override
    public void Layout(int state) {
        if (state == STATE_1) {
            layout = new int[][]{{0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 1},
                    {0, 1, 1, 1}};
        }
        if (state == STATE_2) {
            layout = new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 1}};
        }
        if (state == STATE_3) {
            layout = new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 1, 0, 0}};
        }
        if (state == STATE_4) {
            layout = new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 1}};
        }

    }
}

package TetrisModel;

/**
 * @author dj
 * @version 1.0
 **/

import java.awt.*;

public class  O_Tetromino extends Tetromino {

    public O_Tetromino(Color color, int state, char type) {
        super(color, state, type);
        Layout(state);
    }

    @Override
    public void Layout(int state) {
        layout = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}};
    }

}

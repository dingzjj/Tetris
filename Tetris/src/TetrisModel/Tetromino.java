package TetrisModel;

import Setting.TetrisToColor;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dj
 * @version 1.0
 **/

public class Tetromino implements TetrisModel {
    //colors中有该程序方块会用到的所有颜色


    //存储形式
    int[][] layout;
    //顺时针四种状态
    public final static int STATE_1 = 1;
    public final static int STATE_2 = 2;
    public final static int STATE_3 = 3;
    public final static int STATE_4 = 4;
    //the color of the Tetromino
    private Color color;

    //every Tetromino has four states
    private int state;

    //方块是哪种类型
    private char type;

    public Tetromino(Color color, int state, char type) {
        this.color = color;
        this.state = state;
        this.type = type;
    }

    public static Tetromino createTetromino( int state, char type) {
        Color color = TetrisToColor.colors.get(type).getColor();
        Tetromino result = null;
        switch (type) {
            case 'I':
                result= new I_Tetromino(color, state, type);
                break;
            case 'O':
                result= new O_Tetromino(color, state, type);
                break;
            case 'T':
                result= new T_Tetromino(color, state, type);
                break;
            case 'L':
                result= new L_Tetromino(color, state, type);
                break;
            case 'J':
                result= new J_Tetromino(color, state, type);
                break;
            case 'S':
                result= new S_Tetromino(color, state, type);
                break;
            case 'Z':
                result= new Z_Tetromino(color, state, type);
                break;
        }
        if(result == null){
            System.out.println("ERROR : result is null");
        }
        staticColoring(type, result.getLayout());
        return result;

    }

    public Tetromino() {
    }

    public Tetromino(Color color, int state) {
        this.color = color;
        this.state = state;
    }

    public Tetromino(int state, char type) {
        this.state = state;
        this.type = type;
    }

    public int[][] getLayout() {
        return layout;
    }

    public void setLayout(int[][] layout) {
        this.layout = layout;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public void Layout(int state) {
        System.out.println("Error：调用了父类的layout");
    }


    public  static void  staticColoring(char  type,int[][] layout) {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                if(layout[i][j] != 0){
                    layout[i][j] =  layout[i][j]%10 + 10* TetrisToColor.colors.get(type).getNumber();
                }

            }
        }
    }


}












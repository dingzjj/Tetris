package TetrisModel;

import Setting.TetrisToColor;

import java.awt.*;

/**
 * @author dj
 * @version 1.0
 **/


public class CurrentTetromino extends Tetromino {
    //里面封装了一个F方块
    private static Tetromino current;
    //右下角点的位置
    private  Point location;

    private  double fallState;


    public Tetromino getCurrent() {
        return current;
    }



    public Point getLocation() {
        return location;
    }

    public void setLocation(int x ,int y) {
        this.location = new Point(x,y);
    }

    public void setState(int state) {
        if(state == 5){
            state = STATE_1;
        }else if(state ==0){
            state =STATE_4;
        }
        current.setState(state);
        current = Tetromino.createTetromino(state, current.getType());
        Running();
    }

    public  void renewCurrentTetromino() {
        {
            current = NextTetris.getNextTetris().getNext();
            NextTetris.renewNextTetris();
            location = new Point(StadiumInGame.getStadiumInGame().stadiumInGameWeight/ 2, StadiumInGame.getStadiumInGame().stadiumInGameHeight - 4);
            setFallState(2.0);
        }
        //上色
//        Coloring(current.getType(), current.layout);
    }


    public double getFallState() {
        return fallState;
    }

    //修改下落状态时layout(根本)也要变
    public void setFallState(double fallState) {
        this.fallState = fallState;
        Running();
    }


//    public void Coloring(char type, int[][] layout) {
//        for (int i = 0; i < layout.length; i++) {
//            for (int j = 0; j < layout[i].length; j++) {
//                if (layout[i][j] != 0) {
//                    layout[i][j] = (layout[i][j] % 10) + (10 * TetrisToColor.colors.get(type).getNumber());
//                }
//
//            }
//        }
//    }

    public void Running() {
        for (int i = 0; i < current.getLayout().length; i++) {
            for (int j = 0; j < current.getLayout()[i].length; j++) {
                if (current.getLayout()[i][j] != 0) {
                    int layout_ten = current.getLayout()[i][j] / 10;
                    current.getLayout()[i][j] = layout_ten * 10 + (int) fallState;
                }

            }
        }

    }

    //单例设计模式
    private CurrentTetromino(int state, char type) {
        super(state, type);
        current = Tetromino.createTetromino(state, type);
        location = new Point(StadiumInGame.getStadiumInGame().stadiumInGameWeight/ 2, StadiumInGame.getStadiumInGame().stadiumInGameHeight - 4);
        fallState = 2.0;
        Running();
        //上色
        Tetromino.staticColoring(type, current.layout);
    }

    private static CurrentTetromino currentTetromino;

    public static CurrentTetromino getCurrentTetromino() {
        if (currentTetromino == null) {
            //第一次获得
            final Tetromino next = NextTetris.getNextTetris().getNext();
            currentTetromino = new CurrentTetromino(next.getState(), next.getType());
        }
        return currentTetromino;
    }


}


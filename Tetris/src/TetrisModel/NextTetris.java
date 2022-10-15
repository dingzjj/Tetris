package TetrisModel;

import Setting.NumberToType;
import TetrisView.NextTetrisArea;

import java.util.Random;

/**
 * @author dj
 * @version 1.0
 * 仅仅用来抽取下一个
 **/



public class NextTetris {
    private static Random r = new Random();
    private static Tetromino next;

    public static void renewNextTetris(){
        int type;
        type = r.nextInt(7)+1;
        final Character type_character = NumberToType.numberToType.get(type);
        Tetromino tetromino = Tetromino.createTetromino(Tetromino.STATE_1,type_character);
        next = tetromino;
        System.out.println(type_character);
    }


    //单例设计模式
    private static NextTetris nextTetris;
    public static NextTetris getNextTetris() {
        if (nextTetris == null) {
            nextTetris = new NextTetris();
            renewNextTetris();
        }

        return nextTetris;
    }
    private NextTetris() {}






    public Tetromino getNext() {
        return next;
    }

    public void setNext(Tetromino next) {
        this.next = next;
    }


}

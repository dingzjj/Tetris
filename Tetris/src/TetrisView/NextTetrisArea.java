package TetrisView;

import TetrisModel.NextTetris;
import TetrisModel.Tetromino;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author dj
 * @version 1.0
 **/

public class NextTetrisArea implements  PaintArea{

    /*
    //下一个方块区域
        Rectangle2D nextTetrisArea = new Rectangle2D.Double(930, 230, 300, 230);
        g2.draw(nextTetrisArea);
     */

    @Override
    public void paintArea(Graphics2D g2) {
        g2.setColor(Color.black);
        Font font = new Font("Serif", Font.BOLD, 30);
        g2.setFont(font);
        g2.drawString("next:",1030,250);
        final Tetromino next = NextTetris.getNextTetris().getNext();
        for (int i = 0; i < next.getLayout().length; i++) {
            for (int j = 0; j < next.getLayout()[i].length; j++) {
                if((next.getLayout()[i][j] % 10) != 0){
                    //有区域的部分
                    final Rectangle2D rectangle2D = new Rectangle2D.Double(1000+j*20, 265+i*20, 20, 20);
                    g2.setColor(next.getColor());
                    g2.fill(rectangle2D);
                    g2.setColor(Color.black);
                }
            }
        }
    }

    //单例设计模式
    private static NextTetrisArea nextTetrisArea;
    public static NextTetrisArea getNextTetrisArea() {
        if (nextTetrisArea == null) {
            nextTetrisArea = new NextTetrisArea();
        }
        return nextTetrisArea;
    }
    private NextTetrisArea() {}
}

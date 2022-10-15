package TetrisView;

import TetrisControl.PlayAreaThread;
import TetrisControl.CurrentTetrominoThread;
import TetrisControl.PressListener;
import TetrisControl.StartAction;
import TetrisModel.CurrentTetromino;
import TetrisModel.StadiumInGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

/**
 * @author dj
 * @version 1.0
 * 游戏显示
 **/


public class TetrisPanel extends JPanel {
    private static final long serialVersionUID = -807909536278284335L;

    public TetrisPanel() {
        setFocusable(true);
        addKeyListener(new PressListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(1300, 1000);


        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        //创建游戏区域
        Rectangle2D playingArea = new Rectangle2D.Double(10, 10, 800, 800);
        g2.draw(playingArea);
        PlayingArea.getPlayingArea().paintArea(g2);
//        g2.setColor(Color.CYAN);
//        g2.fill(new Rectangle2D.Double(10,10,800,800));

        //结束线
        g2.drawLine(10,90,810,90);

        //积分区域
        Rectangle2D scoreArea = new Rectangle2D.Double(900, 10, 350, 200);
        g2.draw(scoreArea);
        ScoreArea.getScoreArea().paintArea(g2);

        //下一个方块区域
        Rectangle2D nextTetrisArea = new Rectangle2D.Double(930, 230, 300, 230);
        g2.draw(nextTetrisArea);
        NextTetrisArea.getNextTetrisArea().paintArea(g2);


        //说明explain区域
        final Rectangle2D explainArea = new Rectangle2D.Double(900, 480, 350, 350);
        g2.draw(explainArea);
        ExplainArea.getExplainArea().paintArea(g2);


    }


}





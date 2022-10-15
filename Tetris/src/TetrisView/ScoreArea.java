package TetrisView;

import Setting.Score;


import java.awt.*;

/**
 * @author dj
 * @version 1.0
 **/

public class ScoreArea implements PaintArea{
    /*
        积分区域
        Rectangle2D scoreArea = new Rectangle2D.Double(900, 10, 350, 200);
        g2.draw(scoreArea);
     */


    @Override
    public void paintArea(Graphics2D g2) {
        g2.setColor(Color.black);
        final Font font = new Font("Serif", Font.BOLD, 30);
        g2.setFont(font);
        g2.drawString("High-score:"+Score.highScore,925,50);
        g2.drawString("now Score:"+Score.nowScore,925,100);

    }

    //单例设计模式
    private static ScoreArea scoreArea;
    public static ScoreArea getScoreArea() {
        if (scoreArea == null) {
            scoreArea = new ScoreArea();
        }
        return scoreArea;
    }
    private ScoreArea() {}
}

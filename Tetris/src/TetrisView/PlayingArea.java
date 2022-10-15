package TetrisView;

import Setting.ColorToNumber;
import Setting.NumberToType;
import Setting.TetrisToColor;
import TetrisModel.StadiumInGame;
import java.awt.*;
import java.awt.geom.Rectangle2D;


/**
 * @author dj
 * @version 1.0
 **/

public class PlayingArea implements PaintArea {

    /*
    Rectangle2D playingArea = new Rectangle2D.Double(10, 10, 800, 800);
        g2.draw(playingArea);
     */
    @Override
    public void paintArea(Graphics2D g2) {
        int[][] layoutInGame = StadiumInGame.getStadiumInGame().getLayoutInGame();
        for (int i = 0; i < layoutInGame.length - 3; i++) {
            for (int j = 0; j < layoutInGame[i].length; j++) {
                Color color;
                Rectangle2D tetris;
                int n = layoutInGame[i][j] % 10;
                int x = 10 + 40 * j;
                int y = 10 + 40 * (19 - i);
                //确定状态
                switch (n) {
                    case 3:
                        y += 10;
                        break;
                    case 4:
                        y += 20;
                        break;
                    case 5:
                        y += 30;
                        break;
                }


                if (n != 0) {
                    //确定颜色 number to color
                    int colorNumber = layoutInGame[i][j] / 10;
                    Character character = NumberToType.numberToType.get(colorNumber);
                    color = TetrisToColor.colors.getOrDefault(character, new ColorToNumber(Color.BLUE, 4)).getColor();
//                    color = TetrisToColor.colors.get(character).getColor();
                    g2.setColor(color);
                    tetris = new Rectangle2D.Double(x, y, 40, 40);
                    g2.fill(tetris);
                }
            }

        }


    }


    //单例设计模式
    private static PlayingArea playingArea;

    public static PlayingArea getPlayingArea() {
        if (playingArea == null) {
            playingArea = new PlayingArea();
        }
        return playingArea;
    }

    private PlayingArea() {
    }
}

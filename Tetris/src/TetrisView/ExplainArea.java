package TetrisView;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author dj
 * @version 1.0
 **/

public class ExplainArea implements PaintArea{
//
//    final Rectangle2D explainArea = new Rectangle2D.Double(900, 480, 350, 350);
//        g2.draw(explainArea);
    @Override
    public void paintArea(Graphics2D g2) {
        g2.setColor(Color.black);
        Font font = new Font("Serif", Font.BOLD, 30);
        g2.setFont(font);
        g2.drawString("explain:",1000,510);
        font = new Font("Monospaced",Font.BOLD,25);
        g2.setFont(font);
        g2.drawString("shortcut key s -> start",900,550);
        g2.drawString("shortcut key p -> pause",900,600);
        font = new Font("Monospaced",Font.BOLD,20);
        g2.setFont(font);
        g2.drawString("shortcut key '->' -> right",900,650);
        g2.drawString("shortcut key '<-' -> left",900,700);
        g2.drawString("shortcut key 'space' ",900,750);
        g2.drawString("-> accelerate",900,780);

    }

    //单例设计模式
    private static ExplainArea explainArea;
    public static ExplainArea getExplainArea() {
        if (explainArea == null) {
            explainArea = new ExplainArea();
        }
        return explainArea;
    }
    private ExplainArea() {}



}

package TetrisControl;

import TetrisModel.CurrentTetromino;
import TetrisModel.NextTetris;
import TetrisModel.StadiumInGame;

import java.awt.*;

/**
 * @author dj
 * @version 1.0
 * 更新currentTetromino的坐标和数据
 **/

public class CurrentTetrominoThread implements Runnable {
    private boolean loop=true;
    @Override
    public void run() {
        while (loop) {
            if(!StartAction.isStart){
                //有关闭的话，线程终止
                loop = false;

            }
            CurrentTetromino currentTetromino = CurrentTetromino.getCurrentTetromino();

            double fallState = currentTetromino.getFallState();//2->5->2
            if (fallState == 5.0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //改变location
                {
                    currentTetromino.setLocation((int) currentTetromino.getLocation().getX(), (int) (currentTetromino.getLocation().getY() - 1));
                    currentTetromino.setFallState(2.0);
                    StadiumInGame.getStadiumInGame().changeStadium();
                }
                //检测是否touch
                if (StadiumInGame.getStadiumInGame().isTouch()) {
                    //touch之后就要融合
                    StadiumInGame.getStadiumInGame().mix();

                }

            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                currentTetromino.setFallState(fallState + 1.0);
                StadiumInGame.getStadiumInGame().changeStadium();

            }


        }
    }

}

package TetrisControl;

import TetrisView.TetrisFrame;

/**
 * @author dj
 * @version 1.0
 * 用作更新画面，每隔一段时间重画画面
 **/


public class PlayAreaThread implements Runnable{
    @Override
    public void run() {

        while(true){
            while (!StartAction.isStart){}
            TetrisFrame.getTetrisFrame().getGamePanel().repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //pause ->一直循环



        }


    }
}

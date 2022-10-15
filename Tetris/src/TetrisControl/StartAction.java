package TetrisControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author dj
 * @version 1.0
 **/

public class StartAction extends AbstractAction {
    public static boolean isStart=false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart){
            return;
        }
        isStart =true;
        //开始区域
        if(isStart){
            final Thread thread = new Thread(new CurrentTetrominoThread());
            thread.start();
            final Thread thread1 = new Thread(new PlayAreaThread());
            thread1.start();
        }

    }
    public StartAction(){
        putValue(Action.NAME,"start");

        //shortcut
        putValue(Action.MNEMONIC_KEY,new Integer('s'));

//        putValue(Action.ACCELERATOR_KEY,"s");
    }



}
package TetrisControl;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author dj
 * @version 1.0
 **/

public class PauseAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!StartAction.isStart){
            return;
        }
        StartAction.isStart =false;


        //开始区域
//        System.out.println("pause");
    }

    public PauseAction(){
        putValue(Action.NAME,"pause");
        putValue(Action.MNEMONIC_KEY,new Integer('p'));
//        putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke("p"));
    }
}

package TetrisControl;

import IO.ConsoleOutput.PrintAreaInConsole;
import TetrisModel.CurrentTetromino;
import TetrisModel.StadiumInGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author dj
 * @version 1.0
 **/

public class PressListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!StartAction.isStart && e.getKeyCode() == 83) {
            StartAction.isStart = true;
            //开始区域
            if (StartAction.isStart) {
                final Thread thread = new Thread(new CurrentTetrominoThread());
                thread.start();
                final Thread thread1 = new Thread(new PlayAreaThread());
                thread1.start();
            }
        }

        if(StartAction.isStart && e.getKeyCode()==80){
            StartAction.isStart =false;
        }

        if (StartAction.isStart) {
            //已经开始了
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (!StadiumInGame.getStadiumInGame().isTouch_L()) {
                        //能往左移动
                        //改变location
                        {
                            CurrentTetromino currentTetromino = CurrentTetromino.getCurrentTetromino();
                            Point location = currentTetromino.getLocation();
                            location.setLocation(location.getX() - 1, location.getY());
                            StadiumInGame.getStadiumInGame().changeStadium();
                        }
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!StadiumInGame.getStadiumInGame().isTouch_R()) {
                        //能往右移动
                        {
                            CurrentTetromino currentTetromino = CurrentTetromino.getCurrentTetromino();
                            Point location = currentTetromino.getLocation();
                            location.setLocation(location.getX() + 1, location.getY());
                            StadiumInGame.getStadiumInGame().changeStadium();
                        }

                    }
                    break;
                    case KeyEvent.VK_UP:
                        if(!StadiumInGame.getStadiumInGame().isTouch()){
                            CurrentTetromino currentTetromino = CurrentTetromino.getCurrentTetromino();
//                            test
//                            PrintAreaInConsole.printArea(StadiumInGame.getStadiumInGame().getLayoutInGame());
                            final int state = currentTetromino.getCurrent().getState();
                            currentTetromino.setState(state+1) ;
                            if(StadiumInGame.getStadiumInGame().isTouch_U_D()){
                                PrintAreaInConsole.printArea(StadiumInGame.getStadiumInGame().getLayoutInGame());
                                currentTetromino.setState(state) ;
                                PrintAreaInConsole.printArea(StadiumInGame.getStadiumInGame().getLayoutInGame());
                            }

                            StadiumInGame.getStadiumInGame().changeStadium();
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(!StadiumInGame.getStadiumInGame().isTouch()){
                            CurrentTetromino currentTetromino = CurrentTetromino.getCurrentTetromino();
                            final int state = currentTetromino.getCurrent().getState();
                            currentTetromino.setState(state-1) ;
//
                            if(StadiumInGame.getStadiumInGame().isTouch_U_D()){
                                System.out.println("ssss");

                                currentTetromino.setState(state) ;
                            }
                            StadiumInGame.getStadiumInGame().changeStadium();
                        }
                        break;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
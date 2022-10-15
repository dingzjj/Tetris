package TetrisModel;


import Setting.Score;
import TetrisControl.StartAction;
import TetrisView.TetrisFrame;

import javax.swing.*;


/**
 * @author dj
 * @version 1.0
 **/

public class StadiumInGame {
    private int[][] layoutInGame;
    //跟stadium的一样大
    public int stadiumInGameHeight;
    public int stadiumInGameWeight;


    /*
    每次currentTetris变化时才变化
     */
    public void changeStadium() {
        if (CurrentTetromino.getCurrentTetromino() == null) {
            System.out.println("ERROR:CurrentTetromino.getCurrentTetromino() is null");
        }
        //先把全部运动态的置为空
        for (int i = 0; i < getLayoutInGame().length; i++) {
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {

                if (getLayoutInGame()[i][j] % 10 != 1 && getLayoutInGame()[i][j] % 10 != 0) {
                    getLayoutInGame()[i][j] = 0;
                }
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (CurrentTetromino.getCurrentTetromino().getCurrent().getLayout()[i][j] % 10 != 0) {
                   int x = (int) CurrentTetromino.getCurrentTetromino().getLocation().getX() - (3 - j) - 1;
                   int y = (int) CurrentTetromino.getCurrentTetromino().getLocation().getY() + (3 - i) - 1;


                    layoutInGame[y][x] = CurrentTetromino.getCurrentTetromino().getCurrent().getLayout()[i][j];
                }

            }

        }

    }

    //判断运动的方块的当前位置是否与盘内元素重合或与底接触，接触
    public boolean isTouch() {
        for (int i = 1; i < getLayoutInGame().length; i++) {
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {
                //运动方块的下面是稳定态方块时
                //%10是状态，/10是颜色
                int n = getLayoutInGame()[i][j] % 10;
                if (n != 0 && n != 1) {
                    if ((getLayoutInGame()[i - 1][j] % 10) == 1) {
                        return true;
                    }

                }
            }

        }

        for (int j = 0; j < getLayoutInGame()[0].length; j++) {
            int m = getLayoutInGame()[0][j] % 10;
//            printArea();
            if (m != 1 && m != 0) {
                //底层有运动态，必定接触
                return true;
            }
        }


        //以上情况都没有触发，说明未接触
        return false;
    }

    public boolean isTouch_L() {
        for (int i = 0; i < getLayoutInGame().length; i++) {
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {
                //运动方块的下面是稳定态方块时
                //%10是状态，/10是颜色
                int n = getLayoutInGame()[i][j] % 10;
                if (n != 0 && n != 1) {
                    //墙或方块导致的卡墙
                    //左墙
                    if (j == 0) {
                        return true;
                    }
                    //左方块
                    if ((getLayoutInGame()[i][j - 1] % 10) == 1) {
                        return true;
                    }

                    if (n != 2) {
                        if ((getLayoutInGame()[i - 1][j - 1] % 10) == 1) {
                            return true;
                        }


                    }

                }
            }

        }

        return false;
    }

    public boolean isTouch_R() {
        for (int i = 0; i < getLayoutInGame().length; i++) {
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {
                //运动方块的下面是稳定态方块时
                //%10是状态，/10是颜色
                int n = getLayoutInGame()[i][j] % 10;
                if (n != 0 && n != 1) {
                    //墙或方块导致的卡墙
                    //右墙
                    if (j == stadiumInGameWeight - 1) {
                        return true;
                    }
                    //右方块
                    if ((getLayoutInGame()[i][j + 1] % 10) == 1) {
                        return true;
                    }
                    if (n != 2) {
                        if ((getLayoutInGame()[i - 1][j + 1] % 10) == 1) {
                            return true;
                        }

                    }

                }
            }

        }

        return false;
    }

    public boolean isTouch_U_D() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (CurrentTetromino.getCurrentTetromino().getCurrent().getLayout()[i][j] % 10 != 0) {
                    int x = (int) CurrentTetromino.getCurrentTetromino().getLocation().getX() - (3 - j) ;
                    if (x <= 0 ) {
                        return true;
                    }
                }
                //如果转换时原来是有东西的
//                int x_ = (int) (CurrentTetromino.getCurrentTetromino().getLocation().getX() - (3 - j))-1;
//                int y_ = (int) (CurrentTetromino.getCurrentTetromino().getLocation().getY() - (3 - j))-1;
//                if (getLayoutInGame()[y_][x_] %10 ==1){
//                    return true;
//                }
            }
        }

        return false;
    }

    /*
    是否成功融合,将运动的方块和stadium融合
     */
    public void mix() {
//        PrintAreaInConsole.printArea(getLayoutInGame());
        for (int i = 0; i < getLayoutInGame().length; i++) {
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {
                int state_ = getLayoutInGame()[i][j] % 10;
                if (state_ != 0 && state_ != 1) {
                    //运动状态的方块都变成稳定态
                    layoutInGame[i][j] = (getLayoutInGame()[i][j] / 10 * 10) + 1;
                }
            }
        }
        //mix之后current的location要重置
        CurrentTetromino.getCurrentTetromino().renewCurrentTetromino();


        //判断是否结束
        for (int i = 0; i < getLayoutInGame()[18].length; i++) {
            if(layoutInGame[18][i] %10 == 1){
                JOptionPane.showMessageDialog(TetrisFrame.getTetrisFrame().getGamePanel(),"end");
                StartAction.isStart =false;
                return;
            }
        }
        for (int i = 0; i < getLayoutInGame().length; i++) {
            boolean loop = true;
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {
                if(getLayoutInGame()[i][j] %10 != 1){
                    loop =false;
                    break;
                }

            }
            if(loop){
                cleanLine(i);
            }


        }


    }

    public void cleanLine(int numberOfLine){
        Score.addNowScore();
        for (int i = numberOfLine; i <getLayoutInGame().length-1 ; i++) {
            for (int j = 0; j < getLayoutInGame()[i].length; j++) {
                getLayoutInGame()[i][j] = getLayoutInGame()[i+1][j];
            }
        }

    }


    //单例模式
    private static StadiumInGame stadiumInGame;

    public static StadiumInGame getStadiumInGame() {

        if (stadiumInGame == null) {
            stadiumInGame = new StadiumInGame(20, 24);
        }
        return stadiumInGame;
    }

    private StadiumInGame(int weight, int height) {
        stadiumInGameHeight = height;
        stadiumInGameWeight = weight;
        layoutInGame = new int[height][weight];

    }

    public synchronized int[][] getLayoutInGame() {
        return layoutInGame;
    }


}

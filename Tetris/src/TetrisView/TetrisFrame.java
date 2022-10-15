package TetrisView;

import TetrisControl.PauseAction;
import TetrisControl.StartAction;


import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author dj
 * @version 1.0
 **/

public class TetrisFrame extends JFrame {
    private TetrisPanel gamePanel = new TetrisPanel();
    //创建即运行


    public void startGame() {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //初始化
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //游戏视图
                add(gamePanel);


                //Frame的配置
                //大小
                setSize(1300,1000);
                //图标
                setIconImage(new ImageIcon("src/Setting/GameIcon.png").getImage());
                //title
                setTitle("Tetris");

                //菜单
                JMenuBar jMenuBar = new JMenuBar();
                frame.setJMenuBar(jMenuBar);

                JMenu fileItem = new JMenu("File");
                jMenuBar.add(fileItem);



                //开始菜单 暂停菜单
                JMenu startOrPauseItem = new JMenu("StartOrPause");

                final PauseAction pauseAction = new PauseAction();
                final StartAction startAction = new StartAction();

                final JMenuItem startItem = new JMenuItem(startAction);
//                startItem.setAccelerator(KeyStroke.getKeyStroke("s"));
                final JMenuItem pauseItem = new JMenuItem(pauseAction);
//                pauseItem.setAccelerator(KeyStroke.getKeyStroke("p"));

                jMenuBar.add(startOrPauseItem);
                startOrPauseItem.add(startItem);
                startOrPauseItem.add(pauseItem );



                //保存菜单
                JMenuItem openItem = new JMenuItem("open");
                fileItem.add(openItem);


                //退出菜单
                JMenuItem exitItem = new JMenuItem("exit");
                fileItem.add(exitItem);
                exitItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

            }
        });
//    }
    }

    //单例设计模式
    private static  TetrisFrame frame;
    public static TetrisFrame getTetrisFrame() {
        if (frame == null) {
            frame = new TetrisFrame();
        }
        return frame;
    }

    private TetrisFrame() {
    }

    public TetrisPanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(TetrisPanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}






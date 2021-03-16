package turing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChuangKou
{
    // TODO:变量“声明”在此
	KongZhi kz;
    // ----------------------------------------------------------------------------------------
    窗口  ck  = null;
    定时器 ds = null;
    private int delay = 500;
    
    private Font ft = new Font("华文新魏", Font.BOLD, 20);
    
    ChuangKou()
    {
        // TODO:程序初始化在此

    	kz=new KongZhi();
    	
    	kz.chuShiHua();
    	
        // ----------------------------------------------------------------------------------------
        ck = new 窗口();
        // 窗口 宽+2*立体边, 高+2*立体边+标题栏
        ck.setBounds(100,100,5 * 2 + 900, 700 + 2 * 5 + 25);
        // 设定窗口可见性setVisible true/false
        ck.setVisible(true);
        // 延时的毫秒
        ds = new 定时器(1000);
    }

    class 窗口 extends JFrame
    {
        菜单    cd   = null;
        面板    mb   = null;
        窗口监听器 exit = null;
        键盘监听器 jp   = null;

        窗口()     {
            jp = new 键盘监听器();
            this.addKeyListener(jp);

            cd = new 菜单();
            this.setJMenuBar(cd);

            mb = new 面板();
            this.add(mb);

            exit = new 窗口监听器();
            this.addWindowListener(exit);

            this.repaint();
        }

        class 菜单 extends JMenuBar
        {
            JMenu     dan;   // 菜单
            JMenuItem xiang1; // 菜单项

            菜单监听器     cdjtq;

            菜单()
            {
                dan = new JMenu("游戏"); // 菜单
                xiang1 = new JMenuItem("开局"); // 菜单项

                this.add(dan);
                dan.add(xiang1);

                cdjtq = new 菜单监听器();
                xiang1.addActionListener(cdjtq);
            }

            class 菜单监听器 implements ActionListener
            {
                public void actionPerformed(ActionEvent e)
                {
                    // TODO:菜单事件处理
                    if (e.getSource() == xiang1)
                    {

                    }
                }
            }
        }

        class 窗口监听器 extends WindowAdapter
        {
            public void windowClosing(WindowEvent e)
            {
                ds.thread.stop();
                System.exit(0);
            }
        }

        class 键盘监听器 implements KeyListener
        {
            // TODO:键盘处理，可加入KeyEvent.VK_XXX
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                case KeyEvent.VK_LEFT:// 左
                    kz.zhuanXiangCaoZuo(2);
                    break;
                case KeyEvent.VK_RIGHT:// 右
                    kz.zhuanXiangCaoZuo(0);
                    break;
                case KeyEvent.VK_UP:// 上
                    kz.zhuanXiangCaoZuo(1);
                    break;
                case KeyEvent.VK_DOWN:// 下
                    kz.zhuanXiangCaoZuo(3);
                    break;
                case KeyEvent.VK_SPACE:// 空格
                	System.exit(0);
                    break;
                case KeyEvent.VK_W: //加速
                	if (delay-100>0) {
                		delay -= 100;
                	} else {
                		JOptionPane.showMessageDialog(null, "已是最大速度！");
                	}
                	break;
                case KeyEvent.VK_S: //减速
                	delay += 100;
                	break;
                }
                // ----------------------------------------------------------------------------------------
                repaint();
            }

            public void keyReleased(KeyEvent e)
            {
            }

            public void keyTyped(KeyEvent e)
            {
            }
        }

        class 面板 extends JPanel
        {
            鼠标监听器 sb = null;

            面板()  {
            	
                sb = new 鼠标监听器();
                this.addMouseListener(sb);
                this.addMouseMotionListener(sb);
            }

            class 鼠标监听器 extends MouseAdapter implements MouseMotionListener
            {
                public void mousePressed(MouseEvent e)
                {
                }

                public void mouseDragged(MouseEvent e)
                {
                }

                public void mouseMoved(MouseEvent e)
                {
                }

                public void mouseReleased(MouseEvent e)
                {
                }

                public void mouseClicked(MouseEvent e)// 鼠标单击
                {
                    // mx my鼠标的位置
                    int mx = e.getX();
                    int my = e.getY();
                    // 鼠标左键 BUTTON1、右键BUTTON3
                    if (e.getButton() == MouseEvent.BUTTON1)
                    {
                        // TODO:鼠标左键单击
                        // ----------------------------------------------------------------------------------------
                    }

                    repaint();
                }
            }

            public void paint(Graphics g)
            {
                // 设定颜色：RED GREEN BLUE ORANGE WHITE GRAY BLACK PINK
                 g.setColor(Color.BLUE);

                // g.drawRect(左,上,宽,高); //矩形
                // g.fillRect(左,上,宽,高); //实心矩形
                // g.drawOval(左,上,宽,高); //椭圆
                // g.fillOval(左,上,宽,高); //实心椭圆

                // 路径：图片-右键-属性-路径src/
                // Image tu=(new ImageIcon( 路径 )).getImage();
                // g.drawImage(tu,x,y,null);

                // ((Graphics2D)g).setStroke(new BasicStroke(线粗)); //设置线的粗细
                // g.drawLine(点1X, 点1y, 点2X, 点2y); //画线

//                 g.setFont(new Font("华文新魏", Font.BOLD, 22)); //设置字体
//                 g.drawString("Score   ",300, 500); //设置文字

                // TODO:绘图在此

                kz.xianShi(g);
                
                g.setFont(ft); //设置字体
                g.drawString("Score:  "+kz.score,670, 50); //设置文字
                // ----------------------------------------------------------------------------------------
            }
        }
    }

    class 定时器 implements Runnable// 实现Runnable接口
    {
        Thread thread = null;
        long jianGe;
        
        定时器(long jianGe)
        {
            this.jianGe = jianGe;
            thread = new Thread(this);
            thread.start();
        }

        public void run()
        {
            while (true)
            {
                try
                {
                    Thread.sleep(delay);

                    if (this == ds)
                    {
                        // TODO:定时处理
                    	kz.dingShi();

                        // ----------------------------------------------------------------------------------------
                        ck.repaint();
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    // main主方法 ，主类的“入口方法”
    public static void main(String[] args)
    {
        new ChuangKou();
    }
}

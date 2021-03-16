package turing;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * @author Administrator
 * @version 1.0
 * @created 12-三月-2021 8:53:46
 */
public class KongZhi {

	public She she;
	public Dou dou;
	public static int score = 0; 

	public KongZhi(){ }

	public void finalize() throws Throwable {

	}

	public void chuShiHua(){
		she=new She();
		
		dou=new Dou();
	}

	public void dingShi(){
		she.pa();
		
		if ( she.nengChi(dou)  ) 
		{
			she.zhangChang();
			score++;
			
			dou=new Dou();
			for (int i=0;i<she.chang;i++) {
				if (dou.h == she.hangs[i] && dou.l == she.lies[i]) {
					i = -1;
					dou = new Dou();
				}
			}
		} 
		else
		{
			if (she.chuJieMa()   ||  she.ziYaoMa()   ) {	
				JOptionPane.showMessageDialog(null, "游戏失败！");
				System.exit( 0 );
			}
		}
	}

	/**
	 * 
	 * @param g
	 */
	public void xianShi(Graphics g){
		//背景显示
		Image tu=(new ImageIcon( "图片/背景.PNG" )).getImage();
        g.drawImage(tu,0,0,null);
        
        Font ft = new Font("华文新魏",Font.BOLD,20);
        g.setFont(ft); //设置字体
        g.drawString("鼠标点击运行的窗口后", 620, 100);
        g.drawString("按下W加速",670, 150); //设置文字
        g.drawString("按下S减速", 670, 200);
        
		she.xianShi(g);
		
		dou.xianShi(g);
		
	}

	/**
	 * 
	 * @param xinFang
	 */
	public void zhuanXiangCaoZuo(int xinFang){
		if ( she.nengZhuanMa(xinFang)) 
		{
			she.zhuan(xinFang);
		} 
	}

}
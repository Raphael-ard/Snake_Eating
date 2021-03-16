package turing;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * @author Administrator
 * @version 1.0
 * @created 12-三月-2021 8:53:46
 */
public class She {
//	大小
	int[] hangs = new int[400];
	int[] lies = new int[400];
//	初始长度和方向
	int chang = 6;
	int fang = 1;

	public void finalize() throws Throwable {

	}

	public She(){
		for (int j = 0; j<chang; j++) {
			hangs[j] = 10 + j;
			lies[j] = 10;
		}
	}

	public boolean chuJieMa(){
		return hangs[0] == -1 || hangs[0] == 20 || lies[0] == -1 || lies[0] == 20;
	}

	/**
	 * 
	 * @param dou
	 */
	public boolean nengChi(Dou dou){
		
		return hangs[0] == dou.h && lies[0] == dou.l;

	}

	/**
	 * 
	 * @param xinFang
	 */
	public boolean nengZhuanMa(int xinFang){
		return fang%2 != xinFang%2;
	}

	public void pa(){
		
		for (int j=chang;j>=1;j--) {
			hangs[j] = hangs[j-1];
			lies[j] = lies[j-1];
		}
		
		switch(fang) {
			case 0:
				lies[0]++;
				break;
			case 1:
				hangs[0]--;
				break;
			case 2:
				lies[0]--;
				break;
			case 3:
				hangs[0]++;
				break;
		}
	}

	/**
	 * 
	 * @param g
	 */
	public void xianShi(Graphics g){
//		显示 头
		Image tu=(new ImageIcon( "图片/头"+fang+".PNG" )).getImage();
        g.drawImage(tu,10+30*lies[0],10+30*hangs[0],null);
//       显示 身
        for (int j = 1; j<chang;j++) {
        	Image tu2=(new ImageIcon( "图片/身.PNG" )).getImage();
            g.drawImage(tu2,10+30*lies[j],10+30*hangs[j],null);
        }
	}

	public void zhangChang(){
		chang++;
	}

	/**
	 * 
	 * @param xinFang
	 */
	public void zhuan(int xinFang){
		fang = xinFang;
		for (int j=1;j<chang;j++) {
			
		}
	}

	public boolean ziYaoMa(){
		for (int j=1;j<chang;j++) {
			if (hangs[0] == hangs[j] && lies[0] == lies[j])
				return true;
		}
		return false;
	}

}
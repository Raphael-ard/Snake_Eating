package turing;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * @author Administrator
 * @version 1.0
 * @created 12-ÈýÔÂ-2021 8:53:46
 */
public class Dou {
	
	int h;
	int l;
	
	public void finalize() throws Throwable {

	}

	public Dou(){
		h = (int)(20*Math.random());
		l  = (int)(20*Math.random());
	}

	/**
	 * 
	 * @param g
	 */
	public void xianShi(Graphics g){
		Image tu=(new ImageIcon( "Í¼Æ¬/³¬¼¶¶¹.png" )).getImage();
        g.drawImage(tu,10+30*l,10+30*h,null);
	}

}
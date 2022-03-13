package fr.towerDefense.core;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

import graphics.ControlPanel;
import graphics.GamePanel;
import graphics.GameWindow;


public class Main {

	public static void main(String[] args) {
		
		//Runnable run = new Runnable(){
			//public void run(){
				ControlPanel cp = new ControlPanel(new Dimension(250, 600));
				GameWindow gm = new GameWindow(new GamePanel(new Dimension(600, 600), cp), cp, new Dimension(900, 700));
				gm.showMe();
				gm.gameStart();
			//}
		//};
		//SwingUtilities.invokeLater(run);
		//run.run();
	}

}

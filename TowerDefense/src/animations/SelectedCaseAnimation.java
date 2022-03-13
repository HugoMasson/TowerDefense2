package animations;

import java.awt.Color;
import java.awt.Graphics;

public class SelectedCaseAnimation {
	
	public static void boldSelectedAnimation(Graphics g, int caseSize, int y, int x, Color c) {
		g.setColor(c);
		g.fillRect(y*caseSize, x*caseSize, 5, 15);
		g.fillRect(y*caseSize, x*caseSize, 15, 5);
		
		g.fillRect(y*caseSize+caseSize-6, x*caseSize, 5, 15);
		g.fillRect(y*caseSize+caseSize-16, x*caseSize, 15, 5);
		
		g.fillRect(y*caseSize, x*caseSize+caseSize-16, 5, 15);
		g.fillRect(y*caseSize, x*caseSize+caseSize-6, 15, 5);
		 
		g.fillRect(y*caseSize+caseSize-6, x*caseSize+caseSize-16, 5, 15);
		g.fillRect(y*caseSize+caseSize-16, x*caseSize+caseSize-6, 15, 5);
	}
	
	public static void thinSelectedAnimation(Graphics g, int caseSize, int y, int x, Color c) {
		g.setColor(c);
		g.fillRect(y*caseSize, x*caseSize, 4, 10);
		g.fillRect(y*caseSize, x*caseSize, 10, 4);
		 
		g.fillRect(y*caseSize+caseSize-5, x*caseSize, 4, 10);
		g.fillRect(y*caseSize+caseSize-11, x*caseSize, 10, 4);
		
		g.fillRect(y*caseSize, x*caseSize+caseSize-11, 4, 10);
		g.fillRect(y*caseSize, x*caseSize+caseSize-5, 10, 4);
		
		g.fillRect(y*caseSize+caseSize-5, x*caseSize+caseSize-11, 4, 10);
		g.fillRect(y*caseSize+caseSize-11, x*caseSize+caseSize-5, 10, 4);
	}
	
}

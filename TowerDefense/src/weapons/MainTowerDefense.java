package weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MainTowerDefense  extends AbstractDefense {
	
	int hp = 10;

	public MainTowerDefense(int _x, int _y, double _angle) {
		super(_x, _y, 500, 100);
	}

	public void setAngle(double a) { angle = a; }

	public boolean takeDamage() {
		hp--;
		if(hp > 0) {
			return false;
		} 
		System.out.println("Game Over !");
		return true;	//dead
	}

	@Override
	public void draw(Graphics g, int caseSize) {
		g.setColor(Color.cyan);
		g.fillRect(x*caseSize + caseSize/8, y*caseSize + caseSize/8, caseSize/2, caseSize/2);
		
	}

	@Override
	public String getName() {
		return "Main Tower";
	}

	@Override
	public double getAngle() { return angle; }

}

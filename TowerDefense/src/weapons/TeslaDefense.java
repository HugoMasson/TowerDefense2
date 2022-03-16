package weapons;

import java.awt.Color;
import java.awt.Graphics;

public class TeslaDefense extends AbstractDefense {
	
	double dmg = 5;

	public TeslaDefense(int _x, int _y) {
		super(_x, _y, 200, 45);
		
	}
	
	@Override
	public void draw(Graphics g, int caseSize) {
		g.setColor(Color.yellow);
		g.fillRect(x*caseSize + caseSize/4, y*caseSize + caseSize/4, caseSize/2, caseSize/2);
	}
	
	@Override
	public String getName() {
		return "Tesla Tower";
	}

	@Override
	public void setAngle(double a) {  }

	@Override
	public double getAngle() { return 0; }

	@Override
	public double attack() {
		return dmg;
		
	}

}

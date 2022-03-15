package weapons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ArcherDefense extends AbstractDefense{

	public ArcherDefense(int _x, int _y, double _angle) {
		super(_x, _y, 100, 200);
	}

	public void setAngle(double a) { angle = a; }



	@Override
	public void draw(Graphics g, int caseSize) {
		g.setColor(Color.cyan);
		g.fillRect(x*caseSize + caseSize/4, y*caseSize + caseSize/4, caseSize/2, caseSize/2);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.red);
		Rectangle rect2 = new Rectangle(x*caseSize + caseSize/2 - caseSize/16, y*caseSize + caseSize/4, caseSize/8, caseSize/4);
		g2d.rotate(Math.toRadians(angle), x*caseSize+caseSize/2, y*caseSize+caseSize/2);
		g2d.draw(rect2);
		g2d.fill(rect2);
		g2d.rotate(Math.toRadians(-angle), x*caseSize+caseSize/2, y*caseSize+caseSize/2);
	}

	@Override
	public String getName() {
		return "Archer Tower";
	}

	@Override
	public double getAngle() { return angle; }

}

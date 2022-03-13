package weapons;

import java.awt.Graphics;

public abstract class AbstractDefense {
	
	int x, y, lvl, basePrice;
	double damage, angle;
	
	public AbstractDefense(int _x, int _y, int _basePrice) {
		x = _x;
		y = _y;
		lvl = 1;
		basePrice = _basePrice;
	}

	public abstract void draw(Graphics g, int s);
	public abstract String getName();
	public abstract void setAngle(double a);
	public abstract double getAngle();

	public int getPrice() { return basePrice*lvl; }
	public void lvlUp() { lvl++; }
	public int getLvl() { return lvl; }
	
}

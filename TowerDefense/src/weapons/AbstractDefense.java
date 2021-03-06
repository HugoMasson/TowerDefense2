package weapons;

import java.awt.Graphics;

public abstract class AbstractDefense {
	
	int x, y, lvl, basePrice, hp, range;
	double damage, angle;
	
	public AbstractDefense(int _x, int _y, int _basePrice, int _range) {
		x = _x;
		y = _y;
		lvl = 1;
		basePrice = _basePrice;
		range = _range;
	}

	public abstract void draw(Graphics g, int s);
	public abstract String getName();
	public abstract void setAngle(double a);
	public abstract double getAngle();
	public abstract double attack();

	public boolean takeDamage() {
		return false;
	}
	public int getPrice() { return basePrice*lvl; }
	public void lvlUp() { lvl++; }
	public int getLvl() { return lvl; }
	public int getRange() { return range; }
	public int getX() { return x; }
	public int getY() { return y; }
	
}

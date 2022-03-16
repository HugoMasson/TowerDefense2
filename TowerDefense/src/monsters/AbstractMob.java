package monsters;

import java.awt.Graphics;

import helper.CasePath;
import map.Case;

public abstract class AbstractMob {
	
	double maxHealth, health, x, y, targetX, targetY;
	double speed;
	int caseSize, padding, timer;
	boolean immune = true;
	Case[][] map;
	
	public AbstractMob(int _maxHealth, double _speed, double _x, double _y, int _caseSize, int _padding, Case[][] _map, int _timer) {
		maxHealth = _maxHealth;
		health = _maxHealth;
		speed = _speed;
		caseSize = _caseSize;
		x = _x;
		y = _y;
		targetX = -1;
		targetY = -1;
		timer = _timer;
		padding = _padding;
		map = _map;
	}
	
	public abstract void draw(Graphics g);
	
	public boolean takeDamage(double amount) {
		if(health - amount <= 0) {
			return true;
		} else {
			health -= amount;
			return false;
		}
	}
	
	public double getHealthRatio() { return (health/maxHealth); }
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	public void setX(double px) { x = px; }
	public void setY(double py) { y = py; }
	
	private boolean almost(double a, double b) {
		if(a + speed > b && a - speed < b) {
			return true;
		}
		return false;
	}

	public boolean move(CasePath casePath) {
		if(timer <= 0) {
			immune = false;
			int index = -1;
			int xCase = (int) (x/caseSize);
			int yCase = (int) (y/caseSize);
			for(int i = casePath.getPath().length-1; i > 0; i--) {
				if(casePath.getPath()[i][1] == xCase && casePath.getPath()[i][0] == yCase) {
					index = i;
				}
			}
			if(index != -1) {
				//System.out.println((!almost(targetY, y)));
				if(targetX == -1 || (almost(targetX, x) && almost(targetY, y))) {
					targetX = casePath.getPath()[index-1][1]*caseSize+caseSize/2;
					targetY = casePath.getPath()[index-1][0]*caseSize+caseSize/2;
				} else {
					
					if(almost(targetX, x)) {
						if(targetY > y) {
							y+=speed;
						} else {
							y-=speed;
						}
						
					} 
					if(almost(targetY, y)) {
						if(targetX > x) {
							x+=speed;
						} else {
							x-=speed;
						}
					}
				}
				
			} else {
				map[yCase][xCase].getDefense().takeDamage();
				return false;
			}
		} else {
			timer--;
		}
		return true;
	}

}

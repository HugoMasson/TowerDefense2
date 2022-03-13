package monsters;

import java.awt.Graphics;

import helper.CasePath;
import map.Case;

public abstract class AbstractMob {
	
	double maxHealth, health, x, y, targetX, targetY;
	double speed;
	int caseSize, padding;
	Case[][] map;
	
	public AbstractMob(int _maxHealth, double _speed, double _x, double _y, int _caseSize, int _padding, Case[][] _map) {
		maxHealth = _maxHealth;
		health = _maxHealth;
		speed = _speed;
		caseSize = _caseSize;
		x = _x;
		y = _y;
		targetX = -1;
		targetY = -1;
		
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
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	public void setX(double px) { x = px; }
	public void setY(double py) { y = py; }
	
	private boolean almost(double a, double b) {
		if(a + 2 > b && a - 2 < b) {
			return true;
		}
		return false;
	}

	public void move(CasePath casePath) {
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
						y+=2;
					} else {
						y-=2;
					}
					
				} 
				if(almost(targetY, y)) {
					if(targetX > x) {
						x+=2;
					} else {
						x-=2;
					}
				}
			}
			
		} else {
			System.out.println("uwu");
		}
	}

}

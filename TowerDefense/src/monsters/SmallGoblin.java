package monsters;

import java.awt.Color;
import java.awt.Graphics;

import helper.CasePath;
import map.Case;

public class SmallGoblin extends AbstractMob{

	int size;
	
	public SmallGoblin(int _maxHealth, double _speed, double _x, double _y, int _padding, int _caseSize, int _size, Case[][] _map, int _timer) {
		super(_maxHealth, _speed, _x, _y, _caseSize, _padding, _map, _timer);
		size = _size;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int)x-size/2, (int)y-size/2, size, size);
	}

}

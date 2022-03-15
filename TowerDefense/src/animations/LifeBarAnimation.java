package animations;

import java.awt.Color;
import java.awt.Graphics;

import monsters.AbstractMob;

public class LifeBarAnimation {
	
	public static void drawLifeBar(AbstractMob mob, Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)(mob.getX()-5), (int)(mob.getY()-10), 10, 2);
		g.setColor(Color.green);
		g.fillRect((int)(mob.getX()-5), (int)(mob.getY()-10), (int)(10*mob.getHealthRatio()), 2);
	}

}

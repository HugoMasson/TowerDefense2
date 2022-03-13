package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import animations.SelectedCaseAnimation;
import enums.CaseStatus;
import enums.GenerationMode;
import helper.CasePath;
import map.Case;
import map.Map;
import monsters.AbstractMob;
import monsters.MobSpawner;
import weapons.ArcherDefense;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	Dimension dim;
	ControlPanel gp;
	Map map;
	CasePath casePath;
	MobSpawner spawner;
	boolean isSelectedBold;
	boolean running;
	boolean hasSelected;
	int[] lastPosSelected;
	int caseSize;
	final static double FPS = 60;
	final static double UPS = 60;
	final static boolean RENDER_TIME = true;
	
	
	public GamePanel(Dimension _dim, ControlPanel _gp) {
		dim = _dim;
		gp = _gp;
		map = new Map(GenerationMode.READ_FILE);
		casePath = new CasePath(map.getMap());
		
		isSelectedBold = true;
		running = true;
		hasSelected = false;
		lastPosSelected = new int[2];
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.setOpaque(true);	
		
		if(getWidth() >= getHeight()) {
			caseSize = (getHeight()-map.getMap().length) / map.getMap().length;
		} else {
			caseSize = (getWidth()-map.getMap().length) / map.getMap().length;
		}
		spawner = new MobSpawner(caseSize);
		spawner.createMobWave(map.getMap());
		
		this.addMouseListener(new MouseAdapter() {
		    @Override 
		    public void mousePressed(MouseEvent e) {
		    	int x = e.getY()/caseSize;
		    	int y = e.getX()/caseSize;
		    	if(x >= 0 && x < map.getMap().length && y >= 0 && y < map.getMap().length) {
			    	hasSelected = !hasSelected;
			    	if(hasSelected) {
			    		map.getMap()[x][y].setSelected(true);
			    		lastPosSelected[0] = e.getY()/caseSize;
			    		lastPosSelected[1] = e.getX()/caseSize;
			    		if(map.getMap()[x][y].getStatus() == CaseStatus.DEFENSE) {	//defense
		    				gp.attacheMenu(map.getMap()[x][y].getStatus(), map.getMap(), x, y, map.getMap()[x][y].getDefense());
		    			} else {	//other
		    				gp.attacheMenu(map.getMap()[x][y].getStatus(), map.getMap(), x, y);
		    			}
			    	} else {
			    		map.getMap()[lastPosSelected[0]][lastPosSelected[1]].setSelected(false);
			    		if(x != lastPosSelected[0] || y != lastPosSelected[1]) {
			    			map.getMap()[x][y].setSelected(true);
			    			lastPosSelected[0] = x;
				    		lastPosSelected[1] = y;
			    			hasSelected = !hasSelected;
			    			if(map.getMap()[x][y].getStatus() == CaseStatus.DEFENSE) {	//defense
			    				gp.attacheMenu(map.getMap()[x][y].getStatus(), map.getMap(), x, y, map.getMap()[x][y].getDefense());
			    			} else {	//other
			    				gp.attacheMenu(map.getMap()[x][y].getStatus(), map.getMap(), x, y);
			    			}
			    			
			    		}
			    	}
		    	}
		    }
		});
	}
	
	@Override
	 public void paintComponent(Graphics g) {
		 g.clearRect(0, 0, getWidth(), getHeight());
		 for(int x = 0; x < map.getMap().length; x++) {
			 for(int y = 0; y < map.getMap()[x].length; y++) {
				 g.setColor(map.getMap()[x][y].getColor());
				 g.fillRect(y*caseSize, x*caseSize, caseSize-1, caseSize-1);	//draw cases of the map
				 if(map.getMap()[x][y].getDefense() != null) {
					 map.getMap()[x][y].getDefense().draw(g, caseSize);
				 }
				 
				 if(map.getMap()[x][y].isSelected()) {
					 if(isSelectedBold) {
						 SelectedCaseAnimation.boldSelectedAnimation(g, caseSize, y, x, Color.red);
					 } else {
						 SelectedCaseAnimation.thinSelectedAnimation(g, caseSize, y, x, Color.red);
					 }
				 }
			 }
		 }
		 
		 /*
		  * Wave / mob drawing / move handler
		  */
		 for(int i = spawner.getWave().size()-1; i >= 0; i--) {
			 if(!spawner.getWave().get(i).move(casePath)) {	//change by spawner.getWave().get(i).getCasePath() ... getCasePath() simple getter
				 spawner.getWave().remove(i);
			 } else {
				 spawner.getWave().get(i).draw(g);
			 }
		 }
	 }
	 
	 private void getInput() {
		 
	 }
		
	 private void update() {
			
	 }
		
	 private void render() {
		 //map render
		 repaint();
	 }
		
		
	 public void run() {
		 long initialTime = System.nanoTime();
		 final double timeU = 1000000000 / UPS;
		 final double timeF = 1000000000 / FPS;
		 double deltaU = 0, deltaF = 0;
		 int frames = 0, ticks = 0;
		 long timer = System.currentTimeMillis();
		 while (running) {
			 long currentTime = System.nanoTime();
			 deltaU += (currentTime - initialTime) / timeU;
			 deltaF += (currentTime - initialTime) / timeF;
			 initialTime = currentTime;
			 if (deltaU >= 1) {
				 getInput();
				 update();
				 ticks++;
				 deltaU--;
				 if((ticks % (FPS/2)) == 0 && hasSelected) {
					 isSelectedBold = !isSelectedBold;
				 }
				 
			 }
			 if (deltaF >= 1) {
				 render();
				 frames++;
				 deltaF--;
			 }	

			 if(System.currentTimeMillis() - timer > 600) {
				 if (RENDER_TIME) {
					 //System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
				 }	
				 frames = 0;
				 ticks = 0;
				 timer += 600;
			 }
			 
		 }
		 
	 }

	 
}

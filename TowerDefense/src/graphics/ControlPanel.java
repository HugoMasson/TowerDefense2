package graphics;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import enums.CaseStatus;
import graphics.buttonPanel.ClearCaseMenu;
import graphics.buttonPanel.DefenseCaseMenu;
import graphics.buttonPanel.PathCaseMenu;
import graphics.buttonPanel.TowerCaseMenu;
import map.Case;
import weapons.AbstractDefense;

public class ControlPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	Dimension dim;
	
	public ControlPanel(Dimension _dim) {
		dim = _dim;
		this.setSize(dim);
		this.setPreferredSize(_dim);
		this.setOpaque(true);
		this.setBackground(Color.gray);
	}
	
	
	public void attachClearCaseMenu(Case[][] map, int x, int y) {
		this.removeAll();
		this.revalidate();
		this.repaint();
		this.add(new ClearCaseMenu(dim, map, x, y, this));
	}
	
	public void attachDefenseCaseMenu(Case[][] map, int x, int y, AbstractDefense def) {	//also give defense type (archer tesla ...)
		this.removeAll();
		this.revalidate();
		this.repaint();
		this.add(new DefenseCaseMenu(dim, map, x, y, def, this));
	}
	
	public void attachPathCaseMenu() {
		this.removeAll();
		this.revalidate();
		this.repaint();
		this.add(new PathCaseMenu(dim));
	}
	
	public void attachTowerCaseMenu(Case[][] map, int x, int y) {
		this.removeAll();
		this.revalidate();
		this.repaint();
		this.add(new TowerCaseMenu(dim, map, x, y));
	}
	
	public void attacheMenu(CaseStatus s, Case[][] map, int x, int y) {
		if(s == CaseStatus.CLEAR) {
			attachClearCaseMenu(map, x, y);
		} else if(s == CaseStatus.PATH) {
			attachPathCaseMenu();
		} else if(s == CaseStatus.TOWER) {
			attachTowerCaseMenu(map, x, y);
		}
	}
	
	public void attacheMenu(CaseStatus s, Case[][] map, int x, int y, AbstractDefense def) {
		attachDefenseCaseMenu(map, x, y, def);
	}
	
	
}

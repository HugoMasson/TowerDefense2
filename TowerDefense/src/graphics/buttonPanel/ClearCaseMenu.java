package graphics.buttonPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import enums.CaseStatus;
import graphics.ControlPanel;
import map.Case;
import weapons.ArcherDefense;
import weapons.TeslaDefense;

public class ClearCaseMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Dimension dim;
	JPanel infos;
	JButton addArcherDefense;
	JButton addTeslaDefense;

	public ClearCaseMenu(Dimension _dim, Case[][] map, int x, int y, ControlPanel cp) {
		dim = _dim;
		
		infos = new JPanel();
		infos.setPreferredSize(new Dimension(250, 100));
		infos.setBackground(Color.black);
		
		addArcherDefense = new JButton("Archer");
		addTeslaDefense = new JButton("Tesla");
		
		addArcherDefense.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				map[x][y] = new Case(0, CaseStatus.DEFENSE, new ArcherDefense(y, x, 0f));
				cp.attachDefenseCaseMenu(map, x, y, new ArcherDefense(y, x, 0f));
			} 
		});
		
		addTeslaDefense.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				map[x][y] = new Case(0, CaseStatus.DEFENSE, new TeslaDefense(y, x));
				cp.attachDefenseCaseMenu(map, x, y, new TeslaDefense(y, x));
			} 
		});
		
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.add(infos);
		this.setBackground(Color.gray);
		
		this.add(addArcherDefense);
		this.add(addTeslaDefense);
	}

}

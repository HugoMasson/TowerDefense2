package graphics.buttonPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import map.Case;

public class TowerCaseMenu extends JPanel{

	private static final long serialVersionUID = 1L;

	Dimension dim;
	JPanel infos;
	
	public TowerCaseMenu(Dimension _dim, Case[][] map, int x, int y) {
		dim = _dim;
		
		infos = new JPanel();
		infos.setPreferredSize(new Dimension(250, 100));
		infos.setBackground(Color.black);
		
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.add(infos);
		this.setBackground(Color.gray);
	
	}
	
}

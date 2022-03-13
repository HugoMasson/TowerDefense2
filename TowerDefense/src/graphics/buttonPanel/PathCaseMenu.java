package graphics.buttonPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PathCaseMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Dimension dim;
	JPanel infos;
	
	public PathCaseMenu(Dimension _dim) {
		dim = _dim;
		
		infos = new JPanel();
		infos.setPreferredSize(new Dimension(250, 100));
		infos.setBackground(Color.black);
	
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.setBackground(Color.gray);
		this.add(infos);
	}
	
	

}

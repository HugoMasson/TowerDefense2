package graphics.buttonPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import enums.CaseStatus;
import graphics.ControlPanel;
import map.Case;
import weapons.AbstractDefense;

public class DefenseCaseMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	
	AbstractDefense def;
	Dimension dim;
	JPanel infos;
	JButton UpgradeDefense;
	JButton DeleteDefense;
	JTextArea jta;
	
	public DefenseCaseMenu(Dimension _dim, Case[][] map, int x, int y, AbstractDefense _def, ControlPanel cp) {
		dim = _dim;
		def = _def;
		jta = new JTextArea(def.getName() +"\nLvl: " + String.valueOf(def.getLvl())+"\nUpgrade Price: "+def.getPrice()+ " gold");
		jta.setEditable(false);
		jta.setHighlighter( null );
		jta.setForeground(Color.white);
		jta.setBackground(Color.black);
		
		infos = new JPanel();
		infos.setPreferredSize(new Dimension(250, 100));
		infos.setBackground(Color.black);
		
		UpgradeDefense = new JButton("Upgrade");
		DeleteDefense = new JButton("Delete");
		
		UpgradeDefense.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
			    
			    map[x][y].getDefense().lvlUp();
			    System.out.println("Upgrade: "+map[x][y].getDefense().getLvl());
			    jta.setText(def.getName() +"\nLvl: " + String.valueOf(map[x][y].getDefense().getLvl())+"\nUpgrade Price: "+map[x][y].getDefense().getPrice()+ " gold");
			} 
		});
		
		DeleteDefense.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				map[x][y] = new Case(map[x][y].getHeight(), CaseStatus.CLEAR);
				cp.attachClearCaseMenu(map, x, y);
			}
		});
		
		infos.add(jta);
		
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.add(infos);
		this.setBackground(Color.gray);
		
		this.add(UpgradeDefense);
		if(def.getName() != "Main Tower") {
			this.add(DeleteDefense);
		}
		
	}

}

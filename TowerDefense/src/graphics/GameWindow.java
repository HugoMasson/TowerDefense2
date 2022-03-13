package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel pan;
	GamePanel game;
	ControlPanel control;
	

	
	public GameWindow(GamePanel _game, ControlPanel _control ,Dimension dim) {
		pan = new JPanel();
		pan.setSize(dim);
		pan.setBackground(Color.gray);
		
		game = _game;
		control = _control;
		this.setSize(dim);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Tower Defense");

		pan.add(game);
		pan.add(control);
		this.add(pan);
	}
	
	public void showMe() {
		this.setVisible(true);
	}
	
	public void gameStart() {
		game.run();
	}
	

}


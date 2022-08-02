package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameOverView extends JFrame {
	private JLabel gameOver;
	public GameOverView() {
		
		ImageIcon logo = new ImageIcon("logo.jpg");
		Border border = BorderFactory.createLineBorder(Color.black,2);
		
		this.setSize(400,400);
		this.setBackground(Color.red);
		this.setTitle("The Conqueror");
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		
		gameOver = new JLabel();
		gameOver.setBorder(border);
		gameOver.setPreferredSize(new Dimension(400,400));
		gameOver.setHorizontalAlignment(JLabel.CENTER);
		gameOver.setVerticalAlignment(JLabel.CENTER);
		
		
		
		
		this.add(gameOver);
		
	}
	public JLabel getGameOver() {
		return gameOver;
	}
	public void setGameOver(JLabel gameOver) {
		this.gameOver = gameOver;
	}
}

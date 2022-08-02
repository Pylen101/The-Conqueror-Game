package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {
	private JPanel startPanel;
	
	public View() {
		ImageIcon logo = new ImageIcon("logo.jpg");
		
		this.setTitle("The Conqueror");
		this.setSize(1000, 800);
		this.setBackground(Color.LIGHT_GRAY);
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setBackground(Color.blue);

		
		startPanel = new JPanel();
		startPanel.setLayout(new GridLayout(5,1));
		startPanel.setSize(this.getWidth(),this.getHeight());
		startPanel.setBackground(Color.LIGHT_GRAY);
		//Adding Textfield to the start panel
		
		this.add(startPanel);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	public JPanel getStartPanel() {
		return startPanel;
	}
	public void setStartPanel(JPanel startPanel) {
		this.startPanel = startPanel;
	}
	
}

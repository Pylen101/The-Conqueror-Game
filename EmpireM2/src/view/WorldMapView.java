package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class WorldMapView extends JFrame {
	private JPanel dataPanel;
	private JLabel dataLabel;
	private JPanel cityViewPanel;
	private JPanel idleArmies;
	private JPanel marchingArmies;
	private JPanel besiegingArmies;
	private JPanel endTurnPanel; 
	public WorldMapView(){
		Border border = BorderFactory.createLineBorder(Color.black,2);
		
		ImageIcon logo = new ImageIcon("logo.jpg");
		ImageIcon worldMap = new ImageIcon("gameMap.jpg");
		ImageIcon fight = new ImageIcon("Fight.png");
		
		this.setSize(1000, 800);
		this.setBackground(Color.gray);
		this.setTitle("The Conqueror");
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		/*
		Image img = Toolkit.getDefaultToolkit().getImage("gameMap.jpg");
		 this.setContentPane(new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	         }
	      });
	      */
		JPanel map  = new JPanel();
		map.setBounds(0,50, this.getWidth(), 600);
		
		JLabel mapLabel = new JLabel();
		mapLabel.setIcon(worldMap);
		
		cityViewPanel = new JPanel();
		cityViewPanel.setBounds(600,650,400,150);
		cityViewPanel.setBackground(new Color(139,69,19));
		
		dataPanel = new JPanel();
		dataPanel.setBounds(0,0,1000,50);
		dataPanel.setBackground(new Color(139,69,19));
		
		endTurnPanel = new JPanel();
		endTurnPanel.setBounds(300,650,300,150);
		endTurnPanel.setBackground(new Color(139,69,19));
		
		JLabel cityLabel = new JLabel();
		cityLabel.setHorizontalAlignment(JLabel.CENTER);
		cityLabel.setVerticalAlignment(JLabel.CENTER);
		cityLabel.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,20));
		cityLabel.setText("You may only view Controlled Cities");
		
		dataLabel = new JLabel();
		dataLabel.setHorizontalAlignment(JLabel.CENTER);
		dataLabel.setVerticalAlignment(JLabel.CENTER);
		dataLabel.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,20));
		
		idleArmies = new JPanel();
		idleArmies.setBounds(0, 50, 300, 250);
		idleArmies.setBackground(new Color(139,69,19));
		idleArmies.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,8));
		
		marchingArmies = new JPanel();
		marchingArmies.setBounds(0, 300, 300, 250);
		marchingArmies.setBackground(new Color(139,69,19));
		marchingArmies.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,8));
		
		besiegingArmies = new JPanel();
		besiegingArmies.setBounds(0, 550, 300, 250);
		besiegingArmies.setBackground(new Color(139,69,19));
		besiegingArmies.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,8));
		
		
		cityViewPanel.setBorder(border);
		cityViewPanel.add(cityLabel);
		
		endTurnPanel.setBorder(border);
		
		dataPanel.setBorder(border);
		dataPanel.add(dataLabel);
		
		idleArmies.setBorder(border);
		marchingArmies.setBorder(border);
		besiegingArmies.setBorder(border);
		
		map.add(mapLabel);
		
		//this.setEnabled(false);
		this.add(dataPanel);
		this.add(endTurnPanel);
		this.add(idleArmies);
		this.add(marchingArmies);
		this.add(besiegingArmies);
		this.add(map);
		this.add(cityViewPanel);
		

	}
	public JPanel getDataPanel() {
		return dataPanel;
	}
	public void setDataPanel(JPanel dataPanel) {
		this.dataPanel = dataPanel;
	}
	public JLabel getDataLabel() {
		return dataLabel;
	}
	public void setDataLabel(JLabel dataLabel) {
		this.dataLabel = dataLabel;
	}
	public JPanel getCityViewPanel() {
		return cityViewPanel;
	}
	public void setCityViewPanel(JPanel cityViewPanel) {
		this.cityViewPanel = cityViewPanel;
	}
	public JPanel getEndTurnPanel() {
		return endTurnPanel;
	}
	public void setEndTurnPanel(JPanel endTurnPanel) {
		this.endTurnPanel = endTurnPanel;
	}
	public JPanel getIdleArmies() {
		return idleArmies;
	}
	public void setIdleArmies(JPanel idleArmies) {
		this.idleArmies = idleArmies;
	}
	public JPanel getMarchingArmies() {
		return marchingArmies;
	}
	public void setMarchingArmies(JPanel marchingArmies) {
		this.marchingArmies = marchingArmies;
	}
	public JPanel getBesiegingArmies() {
		return besiegingArmies;
	}
	public void setBesiegingArmies(JPanel besiegingArmies) {
		this.besiegingArmies = besiegingArmies;
	}
	
}

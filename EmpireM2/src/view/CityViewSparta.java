package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class CityViewSparta extends JFrame {
	JPanel close;
	JPanel farm;
	JPanel market;
	JPanel archeryRange;
	JPanel barracks;
	JPanel stable;
	JPanel defendingArmyPanel;
	public CityViewSparta() {
		ImageIcon logo = new ImageIcon("logo.jpg");
		Border border = BorderFactory.createLineBorder(Color.black,2);


		this.setSize(1000,800);
		this.setBackground(Color.red);
		this.setTitle("The Conqueror");
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(false);
		
		close = new JPanel();
		close.setBounds(900, 700, 100, 100);
		close.setBackground(new Color(139,69,19));
		
		farm = new JPanel();
		farm.setBounds(0,0,200,300);
		farm.setBackground(new Color(139,69,19));
		
		market = new JPanel();
		market.setBounds(200, 0, 200, 300);
		market.setBackground(new Color(139,69,19));

		
		archeryRange = new JPanel();
		archeryRange.setBounds(400,0,200,300);
		archeryRange.setBackground(new Color(139,69,19));
		
		barracks = new JPanel();
		barracks.setBounds(600,0,200,300);
		barracks.setBackground(new Color(139,69,19));
		
		stable = new JPanel();
		stable.setBounds(800,0,200,300);
		stable.setBackground(new Color(139,69,19));
		
		defendingArmyPanel = new JPanel();
		defendingArmyPanel.setBounds(0,300,this.getWidth()-100,500);
		defendingArmyPanel.setBackground(new Color(139,69,19));
		
		JLabel dlabel = new JLabel();
		dlabel.setText("Defending Army: ");
		dlabel.setPreferredSize(new Dimension(100,30));
		
		JLabel flabel = new JLabel();
		flabel.setText("Farm");
		flabel.setPreferredSize(new Dimension(50,30));
		
		JLabel mlabel = new JLabel();
		mlabel.setText("Market");
		mlabel.setPreferredSize(new Dimension(50,30));
		
		JLabel alabel = new JLabel();
		alabel.setText("ArcheryRange");
		alabel.setPreferredSize(new Dimension(100,30));
		
		JLabel blabel = new JLabel();
		blabel.setText("Barracks");
		blabel.setPreferredSize(new Dimension(50,30));
		
		JLabel slabel = new JLabel();
		slabel.setText("Stable");
		slabel.setPreferredSize(new Dimension(50,30));
		
		farm.setBorder(border);
		market.setBorder(border);
		archeryRange.setBorder(border);
		barracks.setBorder(border);
		stable.setBorder(border);
		defendingArmyPanel.setBorder(border);
		
		farm.add(flabel);
		market.add(mlabel);
		archeryRange.add(alabel);
		barracks.add(blabel);
		stable.add(slabel);
		defendingArmyPanel.add(dlabel);
		
		
		this.add(close);
		this.add(farm);
		this.add(market);
		this.add(archeryRange);
		this.add(barracks);
		this.add(stable);
		this.add(defendingArmyPanel);
	}
	public JPanel getFarm() {
		return farm;
	}
	public void setFarm(JPanel farm) {
		this.farm = farm;
	}
	public JPanel getMarket() {
		return market;
	}
	public void setMarket(JPanel market) {
		this.market = market;
	}
	public JPanel getArcheryRange() {
		return archeryRange;
	}
	public void setArcheryRange(JPanel archeryRange) {
		this.archeryRange = archeryRange;
	}
	public JPanel getBarracks() {
		return barracks;
	}
	public void setBarracks(JPanel barracks) {
		this.barracks = barracks;
	}
	public JPanel getStable() {
		return stable;
	}
	public void setStable(JPanel stable) {
		this.stable = stable;
	}
	public JPanel getClose() {
		return close;
	}
	public void setClose(JPanel close) {
		this.close = close;
	}
	public JPanel getDefendingArmyPanel() {
		return defendingArmyPanel;
	}
	public void setDefendingArmyPanel(JPanel defendingArmyPanel) {
		this.defendingArmyPanel = defendingArmyPanel;
	}
}

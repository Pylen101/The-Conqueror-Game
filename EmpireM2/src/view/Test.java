package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Test {

	public static void main(String[] args) {
		
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		
		JComboBox c = new JComboBox();
		String[] s = {"bird","dog","cat"};
		c = new JComboBox(s);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.red);
		panel1.setBounds(0,0,250,800);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.blue);
		panel2.setBounds(750, 0, 250, 800);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.GRAY);
		panel3.setBounds(250, 0, 500, 800);
		panel3.setLayout(new BorderLayout());
		
		JLabel label = new JLabel(); // creates a label
		label.setText(" The Conqueror"); // set text for label
		ImageIcon image1 = new ImageIcon("Fight.png");
		label.setIcon(image1);
		label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, RIGHT or CENTER of image icon
		label.setVerticalTextPosition(JLabel.TOP); // set text TOP, BOTTOM or CENTER
		label.setForeground(Color.darkGray); // set Font color of text
		label.setFont(new Font("MV Boli",Font.ROMAN_BASELINE ,20)); //set font of text
		label.setIconTextGap(0);
		//label.setBackground(Color.black); //display background color
		label.setOpaque(true);//display background color
		label.setBorder(border);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setBounds(375, 0, 250, 250); // (x,y) are coordinates with 0,0 panel1ing from top left and (width,height) is size
		
		JFrame frame = new JFrame(); //creates a frame
		frame.setTitle("JFrame title goes here"); // sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // prevents frame from being resized
		frame.setLayout(new BorderLayout()); 
		frame.setSize(1000, 800); //sets the x-dimension, and y-dimension of frame
		frame.setVisible(true); //make frame visible
		//frame.pack();
		
		ImageIcon image2 = new ImageIcon("logo.jpg"); // create an image icon
		frame.setIconImage(image2.getImage()); // change icon of frame
		frame.getContentPane().setBackground(new Color(175,120,120));
		
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		
		//panel3.add(label);
		panel3.add(c);
		
		frame.revalidate();
		frame.repaint();
		
	}
}

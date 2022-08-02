package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
	JButton button;
	
	public MyFrame() {
		button = new JButton();
		button.setBounds(200,100, 100, 50);
		button.addActionListener(this);
		button.setText("Click Me!");
		
		this.setTitle("JFrame title goes here"); // sets title of this
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false); // prevents this from being resized
		this.setSize(600, 800); //sets the x-dimension, and y-dimension of this
		this.setVisible(true); //make this visible
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button	) {
			System.out.println("You Did It");
			
		}
		
	}
	
	 
}
 
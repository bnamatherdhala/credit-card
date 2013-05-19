/*
Written for my Intro to Computer Science class.
An A.P. Computer Science project.

Written by K Swis (Odin)
http://github.com/kswis
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CCGUI extends JPanel implements ActionListener
{

	private final int WIDTH = 400;
	private final int HEIGHT = 100;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel inputLabel, resultLabel;
	private JTextField cardNum;
	private JComboBox cardList;
	private JButton button = new JButton("Validate!");
	
	
	//Constructor
	public CCGUI()
	{
		//Make the dropdown menu
		String[] cardTypes = {"Visa","MasterCard","Discover","American Express"};
		cardList = new JComboBox(cardTypes);
		cardList.setSelectedIndex(0);
		
		inputLabel = new JLabel("Enter a credit card type and number:");
		resultLabel = new JLabel("---"); //Changes with validation
		
		cardNum = new JTextField(16);
		
		//Set the panel
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setBackground(new Color(175, 175, 175));
		panel.add(inputLabel);
		panel.add(cardList);
		panel.add(cardNum);
		panel.add(button);
		panel.add(resultLabel);
		button.addActionListener(this);
		
		frame = new JFrame("Credit Card Validator");
		
		//Set the frame up.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String input1 = cardNum.getText();
		long number = Long.parseLong(input1);
		String type = (String)cardList.getSelectedItem();
		
		CreditCard cc = new CreditCard(type,number);
		if(cc.validate())
		{
			resultLabel.setText("Card is valid.");
		}
		else
		{
			resultLabel.setText("Card is invalid.");
		}
	}
}


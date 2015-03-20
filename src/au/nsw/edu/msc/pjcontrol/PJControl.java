package au.nsw.edu.msc.pjcontrol;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PJControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new PJControl();
		
	}
	
	public PJControl() {
		
		Projector pj = new Projector("10.28.7.20");
		
		// Create window
		JFrame guiFrame = new JFrame();
		guiFrame.setTitle("PJ Control");
		guiFrame.setSize(150, 200);
		guiFrame.setLocationRelativeTo(null);
		
		// Use grid layout
		Container pane = guiFrame.getContentPane();
		pane.setLayout(new GridLayout(3,1));
		
		// Create button-press event handler
		ActionListener a = new PJAction(pj);
		
		// Create projector on button
		JButton powerOnButton = new JButton("TURN ON");
		powerOnButton.setName("POWERON");
		powerOnButton.addActionListener(a);
		pane.add(powerOnButton, BorderLayout.SOUTH);
		
		// Create projector off button
		JButton powerOffButton = new JButton("TURN OFF");
		powerOffButton.setName("POWEROFF");
		powerOffButton.addActionListener(a);
		pane.add(powerOffButton, BorderLayout.SOUTH);
		
		// Create projector source button
		JButton sourceButton = new JButton("CHANGE INPUT");
		sourceButton.setName("SOURCE");
		sourceButton.addActionListener(a);
		pane.add(sourceButton);
		
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setVisible(true);
		
	}

}

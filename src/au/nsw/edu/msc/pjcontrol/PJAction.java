package au.nsw.edu.msc.pjcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PJAction implements ActionListener {

	private Projector pj;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton sourceButton = (JButton) event.getSource();
		try {
			pokeThePJ(sourceButton.getName());
		} catch (PJControlException exception) {
			JOptionPane.showMessageDialog(null, exception.toString());
		}
	}
	
	private void pokeThePJ(String command) throws PJControlException {
		switch(command) {
			case "SOURCE": {
				pj.autoSource();
			} break;
			case "POWERON": {
				pj.turnOn();
			} break;
			case "POWEROFF": {
				pj.turnOff();
			} break;
		}
	}
	
	public PJAction(Projector pj) {
		this.pj = pj;
	}

}

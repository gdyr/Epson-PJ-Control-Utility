package au.nsw.edu.msc.pjcontrol;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Projector {
	
	private String ip;
	
	public Projector(String ip) {
		
		// Store IP address
		this.ip = ip;
		
	}
	
	public void turnOn() throws PJControlException {
		sendMessage("PWR ON");
	}
	
	public void turnOff() throws PJControlException {
		sendMessage("PWR OFF");
	}
	
	public void sourceScan() throws PJControlException {
		sendMessage("PWR ON");
	}
	
	public boolean isOn() throws PJControlException {
		return (sendMessage("PWR?") == "01");
	}
	
	public void autoSource() throws PJControlException {
		sendMessage("KEY 67");
	}
	
	private String sendMessage(String message) throws PJControlException {
		try {
			Socket clientSocket = new Socket(this.ip, 3629);
			byte[] startMessage = {0x45, 0x53, 0x43, 0x2f, 0x56, 0x50, 0x2e, 0x6e, 0x65, 0x74, 0x10, 0x03, 0x00, 0x00, 0x00, 0x00};
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outToServer.write(startMessage);
			int x;
			while((x = inFromServer.read()) != 32) { }
			while((x = inFromServer.read()) != 0) { }
			outToServer.writeBytes(message + '\r');
			String reply = "";
			while((x = inFromServer.read()) != ':') { reply += (char) x; }
			clientSocket.close();
			if(reply.startsWith("ERR")) {
				throw new PJControlException();
			}
			return reply;
		} catch(Exception e) {
			throw new PJControlException();
		}
	}
	
}

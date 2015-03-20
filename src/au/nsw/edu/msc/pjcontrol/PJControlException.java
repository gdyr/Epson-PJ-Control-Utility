package au.nsw.edu.msc.pjcontrol;

public class PJControlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7298534333832124315L;
	
	@Override
	public String toString() {
		return "Projector control action failed.";
	}
	
}

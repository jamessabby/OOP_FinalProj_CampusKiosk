package finalterm9_FinalProjectKiosk;

import javax.swing.JOptionPane;

public class GeneralServices { // first feature
	public void showServices() {
		// Departments available
		String[] departments = { "1 - Ayuntamiento", "2 - ICTC", "3 -Aklatang Emilio Aguinaldo", "4 - SWAFO" };

		// Ask the user to select a department
		String selection = (String) JOptionPane.showInputDialog(null,
				"To which department would you like to be connected?", "Select Department",
				JOptionPane.QUESTION_MESSAGE, null, departments, departments[0]);

		// Check if the user canceled the selection
		if (selection != null) {
			// Simulate connection to the selected department
			JOptionPane.showMessageDialog(null, "You are currently being linked to " + selection.split(" - ")[1] + ".",
					"On Call", JOptionPane.INFORMATION_MESSAGE);

			// End call button prompt
			int endCall = JOptionPane.showConfirmDialog(null, "On Call. Click 'OK' to finish.", "End Call",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

			if (endCall == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null, "Call Ended. Thank you for using General Services!", "End Call",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

package finalterm9_FinalProjectKiosk;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class IkotLaSalle { // third feature
	private static IkotLaSalle instance;
	private int passTotal = 12;
	private int passAvail = passTotal;
	private int passReserve;
	private int passRide;
	private int passIncoming;
	private int price;
	private int isDriver;
	public int passReq;
	private String corPass = "1234Test";
	private JLabel label1, label2, label3, label4, label5, label6;
	private JButton btnOK1, btnCheckReq, btnOnboard, btnExit;

	public static IkotLaSalle getInstance() {
		if (instance == null) {
			instance = new IkotLaSalle();
		}
		return instance;
	}

	public void confIsDriver() {
		// Define button options
		String[] options = { "Driver", "Student" };

		// Show the dialog
		int choice = JOptionPane.showOptionDialog(null, "Are you a Student or Driver?", "Confirmation",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		// Execute depends on the choice
		if (choice == 0) {
			driverConfirm();
		} else if (choice == 1) {
			studentFrame();
		}
	}

	public void driverConfirm() {
		// Create Password Field
		JPasswordField passDri = new JPasswordField();
		Object[] options = { passDri, "OK", "Cancel" };

		// Show Dialog
		int option = JOptionPane.showConfirmDialog(null, passDri, "Enter Password", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		// Check Password
		if (option == JOptionPane.OK_OPTION) {
			char[] pass = passDri.getPassword(); // Get the password as a char array
			String passString = new String(pass); // Convert char array to String
			if (passString.equals(corPass)) {
				System.out.println("Password correct!");
				driverFrame(); // Call the method when the password is correct
			} else {
				System.out.println("Incorrect password.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Password input canceled.");
		}
	}

	public void driverFrame() {
		// Setup Frame for Drivers' UI Menu
		JFrame drivFrame = new JFrame("Ikot La Salle Service");
		drivFrame.setSize(700, 500); // width and height
		drivFrame.setLayout(null);
		drivFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drivFrame.setResizable(false);

		// Setup The UI Components
		label1 = new JLabel("Number of Passengers Onboard: ");
		label1.setBounds(25, 25, 200, 25);
		label2 = new JLabel(Integer.toString(passRide));
		label2.setBounds(225, 25, 200, 25);
		label3 = new JLabel("Number of Passengers Reserved: ");
		label3.setBounds(25, 50, 200, 25);
		label4 = new JLabel(Integer.toString(passReserve));
		label4.setBounds(225, 50, 200, 25);
		label5 = new JLabel("Number of Empty Seats: ");
		label5.setBounds(25, 75, 200, 25);
		label6 = new JLabel(Integer.toString(passAvail));
		label6.setBounds(225, 75, 200, 25);

		// Buttons for Different Functions
		btnCheckReq = new JButton("Check Requests");
		btnCheckReq.setBounds(25, 325, 150, 25);
		btnOK1 = new JButton("OK");
		btnOK1.setBounds(175, 325, 100, 25);
		btnOnboard = new JButton("Add Reserves Onboard");
		btnOnboard.setBounds(325, 325, 200, 25);
		btnExit = new JButton("Remove Departing Passengers");
		btnExit.setBounds(225, 375, 300, 25);

		// Event Listeners
		btnCheckReq.addActionListener(e -> checkReq());
		btnOK1.addActionListener(e -> drivFrame.setVisible(false));
		btnOnboard.addActionListener(e -> onBoard());
		btnExit.addActionListener(e -> drop());

		// Combine all Components
		drivFrame.setVisible(true);
		drivFrame.add(label1);
		drivFrame.add(label2);
		drivFrame.add(label3);
		drivFrame.add(label4);
		drivFrame.add(label5);
		drivFrame.add(label6);
		drivFrame.add(btnCheckReq);
		drivFrame.add(btnOK1);
		drivFrame.add(btnOnboard);
		drivFrame.add(btnExit);

	}

	public void checkReq() {
		// Define button options
		String[] options = { "Accept", "Cancel" };

		// Show the number of the Requested Passengers to Accept
		int choice = JOptionPane.showOptionDialog(null,
				"There are " + passIncoming + "Students Requesting for your Ride, Click Accept to Proceed",
				"Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		// Execute depends on the choice
		if (choice == 0) {
			passReserve += passIncoming;
			passAvail = passTotal - (passReserve + passRide);
			label4.setText(Integer.toString(passReserve));
			label6.setText(Integer.toString(passAvail));
			passIncoming = 0;

		} else if (choice == 1) {

		}
	}

	public void onBoard() {
		// Use Operations to Move the Number of Reserve Passengers on Board when Driver
		// Reaches Them
		passRide += passReserve;
		passReserve = 0;
		label2.setText(Integer.toString(passRide));
		label4.setText(Integer.toString(passReserve));
	}

	public void drop() {
		// Input number of dropped Passengers to remove and free up seats
		String str = JOptionPane.showInputDialog(null,
				"Enter the number of Passengers to be Dropped off their Destination");
		int numDrop = Integer.parseInt(str);

		if (numDrop <= passRide) {
			// Using Operations
			passRide -= numDrop;
			passAvail += numDrop;
			label2.setText(Integer.toString(passRide));
			label6.setText(Integer.toString(passAvail));
		} else {
			// When Inputting Invalid Values, the Action will be refused of
			JOptionPane.showMessageDialog(null, "Invalid Input\n" + "More than Expected Number of Passengers", "Error",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void studentFrame() {
		// Display the initial message with Yes/No options
		int choice = JOptionPane.showConfirmDialog(null,
				"Hello fellow Lasallian!\n" + "Ikot La Salle Jeepney is coming your way!\n"
						+ "Do you wish to ride Ikot La Salle?\n\n" + "Please prepare 10 pesos cash only.",
				"Ikot La Salle", JOptionPane.YES_NO_OPTION);

		// Handle Yes/No responses
		if (choice == JOptionPane.YES_OPTION) {
			String str = JOptionPane.showInputDialog(null,
					"Enter the number of Passengers, 10 pesos for each Passenger");
			int numPass = Integer.parseInt(str);
			if (numPass <= passAvail) {
				// Accept The Reservation when there are Enough Available Seats
				int price = 10 * numPass;
				JOptionPane
						.showMessageDialog(null,
								"Enjoy your ride with Ikot La Salle!\n" + "Your " + price
										+ " pesos will be collected.\n" + "Safe travels!",
								"Ride Confirmed", JOptionPane.INFORMATION_MESSAGE);
				passIncoming += numPass;
			} else {
				// When the Reserved Seats don't fit, The Code will Refuse
				JOptionPane.showMessageDialog(null, "Overload!\n" + "Not Enough Available Seats", "Error",
						JOptionPane.INFORMATION_MESSAGE);

			}
		} else if (choice == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Thank you! You may wait for the next trip.\n" + "Have a great day!",
					"Ride Declined", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

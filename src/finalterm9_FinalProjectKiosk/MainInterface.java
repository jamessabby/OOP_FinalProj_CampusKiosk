package finalterm9_FinalProjectKiosk;

import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainInterface {
	private JFrame mainFrame;
	private JButton btnGeneralServices, btnSchoolMap, btnIkotLaSalle;
	private JLabel welcomeLabel, backgroundLabel;

	public MainInterface() {
		initializeMainFrame();
		initializeButtons();
	}

	// Main Frame Initialization
	private void initializeMainFrame() {
		mainFrame = new JFrame("DLSU-D Kiosk Panel");
		mainFrame.setSize(600, 400); // width and height
		mainFrame.setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Adding Background Image
		ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/resources/background.png")); // Replace with your image path
		backgroundLabel = new JLabel(backgroundIcon);
		backgroundLabel.setBounds(0, 0, 600, 400); // Adjust size to match the frame

	
	// Welcome Label Initialization
		welcomeLabel = new JLabel("Select a Service:");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		welcomeLabel.setBounds(100, 30, 300, 30);
		mainFrame.add(welcomeLabel);
		mainFrame.add(backgroundLabel);
	}

	// Initialize Buttons
	private void initializeButtons() {
		btnGeneralServices = new JButton("General Services");
		btnSchoolMap = new JButton("School Map");
		btnIkotLaSalle = new JButton("Ikot La Salle");

		// Button Properties
		btnGeneralServices.setBounds(200, 80, 200, 50);
		btnSchoolMap.setBounds(200, 150, 200, 50);
		btnIkotLaSalle.setBounds(200, 220, 200, 50);

		// Event Listeners
		btnGeneralServices.addActionListener(e -> new GeneralServices().showServices());
		btnSchoolMap.addActionListener(e -> new SchoolMap().showMap());
		btnIkotLaSalle.addActionListener(e -> IkotLaSalle.getInstance().confIsDriver());

		// Add Buttons to the Frame
		mainFrame.add(btnGeneralServices);
		mainFrame.add(btnSchoolMap);
		mainFrame.add(btnIkotLaSalle);

		mainFrame.setVisible(true);
	}
}

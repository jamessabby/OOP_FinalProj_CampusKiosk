package finalterm9_FinalProjectKiosk;

import java.awt.Image;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class SchoolMap {
	private JFrame mapFrame;
	private JButton btnOK, btnShow,btnDef;
	private JLabel mapimage, message;
	private ImageIcon mapimg;
	private JComboBox routes;

	public void showMap() {
		// Display a message simulating the map with a space below the text
		mapFrame = new JFrame("Campus Map");
		mapFrame.setSize(900, 700); // width and height
		mapFrame.setLayout(null);
		mapFrame.setResizable(false);
		mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adding the Message Indicating that you are on the current location
		message = new JLabel("<html>The school map is being shown and you're currently here at the Gate 1 Rotunda Kiosk Station.<html>");
		message.setFont(new Font("Arial", Font.BOLD, 12));
		message.setBounds(50, 30, 800, 40);
		
		//Adding the Images
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/resources/mapcampus.png"));
	    Image resizedImage = originalIcon.getImage().getScaledInstance(650, 500, Image.SCALE_SMOOTH);
	    mapimg = new ImageIcon(resizedImage);

	    mapimage = new JLabel(mapimg);
	    mapimage.setBounds(50, 70, 650, 500);
	    
	    //Adding the Combobox
	    String[] routesList = {"CTH", "MTH", "CBAA", "JFH", "Ayunta", "Gate-3"};
	    routes = new JComboBox(routesList);
	    routes.setBounds(50, 600, 100, 30);
	        
	    //Show Route Button
	    btnShow = new JButton("Show Map");
	    btnShow.setBounds(150, 600, 100, 30);
	    btnShow.addActionListener(e -> changeMap());
	    
	    //Show Route Button
	    btnDef = new JButton("Campus Map");
	    btnDef.setBounds(250, 600, 150, 30);
	    btnDef.addActionListener(e -> defaultMap());
		
		//OK Button for when the user got enough information from the map
		btnOK = new JButton("OK");
		btnOK.setBounds(700, 600, 100, 30);
		btnOK.addActionListener(e -> mapFrame.dispose());
		
		//Adding Components to the Frame
		mapFrame.add(routes);
		mapFrame.add(message);
		mapFrame.add(mapimage);
		mapFrame.setVisible(true);
		mapFrame.add(btnOK);
		mapFrame.add(btnShow);
		mapFrame.add(btnDef);

		
		
		
	}
	
	public void changeMap(){
		// Get the selected route
		String selectedRoute = (String) routes.getSelectedItem();

		// Load the corresponding map based on the selected route
		String imagePath = "/resources/map" + selectedRoute.toLowerCase() + ".png"; // Example path
		ImageIcon newIcon = new ImageIcon(getClass().getResource(imagePath));
		Image resizedImage = newIcon.getImage().getScaledInstance(650, 500, Image.SCALE_SMOOTH);
		mapimg = new ImageIcon(resizedImage);

		// Update the JLabel with the new Map
		mapimage.setIcon(mapimg);

		// Refresh the frame to reflect the changes
		mapimage.revalidate();
		mapimage.repaint();
	}
	
	public void defaultMap(){
		// Get the selected route
		String selectedRoute = (String) routes.getSelectedItem();

		// Load the corresponding image based on the selected route
		String imagePath = "/resources/mapcampus.png"; // Example path
		ImageIcon newIcon = new ImageIcon(getClass().getResource(imagePath));
		Image resizedImage = newIcon.getImage().getScaledInstance(650, 500, Image.SCALE_SMOOTH);
		mapimg = new ImageIcon(resizedImage);

		// Update the JLabel with the new image
		mapimage.setIcon(mapimg);

		// Refresh the frame to reflect the changes
		mapimage.revalidate();
		mapimage.repaint();
	}
	
}

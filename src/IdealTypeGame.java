
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IdealTypeGame {
	static JPanel panelNorth;
	static JPanel panelCenter;
	static JLabel labelMessage;
	static JLabel labelVs;
	static JButton buttonLeft;
	static JButton buttonRight;
	static String[] images = {
		"actress1.jpg", "actress2.jpg", "actress3.jpg", "actress4.jpg",
		"actress5.jpg", "actress6.jpg", "actress7.jpg", "actress8.jpg",
		"actress9.jpg", "actress10.jpg", "actress11.jpg", "actress12.jpg",
		"actress13.jpg", "actress14.jpg", "actress15.jpg", "actress16.jpg",
	};
	static int imageIndex = 2; //3th image index initialized.
	
	//function : image to put on Button Control 
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./"+filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}
	
	static class MyFrame extends JFrame implements ActionListener{
		public MyFrame(String title) {
			super( title );
			
			//UI Init
			this.setSize(450, 250);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panelNorth = new JPanel();
			labelMessage = new JLabel("Find Your Ideal type!");
			labelMessage.setFont(new Font("Arial", Font.BOLD, 20));
			panelNorth.add(labelMessage);
			this.add( "North", panelNorth );
			
			panelCenter = new JPanel();
			labelVs = new JLabel("vs");
			labelVs.setFont(new Font("Arial", Font.BOLD, 20));
			buttonLeft = new JButton("LeftButton");
			buttonLeft.setIcon(changeImage("actress1.jpg"));
			buttonLeft.setPreferredSize(new Dimension(200,200));
			buttonRight = new JButton("RightButton");
			buttonRight.setIcon(changeImage("actress2.jpg"));
			buttonRight.setPreferredSize(new Dimension(200,200));
			//add click event
			buttonLeft.addActionListener(this);
			buttonRight.addActionListener(this);
			panelCenter.add(buttonLeft);
			panelCenter.add(labelVs);
			panelCenter.add(buttonRight);
			this.add( "Center", panelCenter );
			
			this.pack(); //clear empty space => pack!
		}
		
		//Button Click Event Callback
		public void actionPerformed(ActionEvent e) {
			if (imageIndex == 16 ) {
				//Last Idol!
				labelMessage.setText("Found Your Idol!");
				//Show One Image!
				if( e.getActionCommand().equals("LeftButton")) {
					buttonRight.hide();
					labelVs.hide();
				}else {
					buttonLeft.hide();
					labelVs.hide();
				}
			}else {
				if( e.getActionCommand().equals("LeftButton")) {
					//LeftButton Clicked!
					buttonRight.setIcon(changeImage(images[imageIndex]));
					imageIndex++;
				}else {
					//RightButton Clicked!
					buttonLeft.setIcon(changeImage(images[imageIndex]));
					imageIndex++;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		new MyFrame("Idol World Cup");
	}
}

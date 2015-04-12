package sw.app.gui.layout;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SplashScreenView extends JPanel implements IView{
	public SplashScreenView() {
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SplashScreenView.class.getResource("/sw/resource/image/SplashScreenResizedtest.png")));
		add(lblNewLabel);
	}
	
	public void initialize() {
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		//new MainMenuController(this);
		
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

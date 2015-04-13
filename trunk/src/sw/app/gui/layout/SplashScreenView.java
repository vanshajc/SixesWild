package sw.app.gui.layout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashScreenView extends JPanel implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SplashScreenView() {
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SplashScreenView.class.getResource("/sw/resource/image/SplashScreenResizedtest.png")));
		add(lblNewLabel);
		//initialize();
	}
	
	public void initialize() {
/*		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		//new MainMenuController(this);
		*/
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

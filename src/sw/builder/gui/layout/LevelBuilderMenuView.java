package sw.builder.gui.layout;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.view.IView;
import sw.app.gui.view.MainMenuView;
import sw.builder.gui.controller.CreateButtonController;

@SuppressWarnings("serial")
/**
 * @author scyevchak
 */
/** Gui class for the builder main menu. */
public class LevelBuilderMenuView extends JPanel implements IView {
	/** Changes which screens are viewed/ */
	BuilderLayoutManager blm;
	
	/**
	 * Constructor for the main menu gui.
	 * @param blm changes which screens are viewed.
	 */
	public LevelBuilderMenuView(BuilderLayoutManager blm) {
		this.blm = blm;
		setLayout(null);
		initialize();
	}

	/**
	 * Creates the view.
	 */
	@Override
	public void initialize() {		
		
		ImageIcon buttonCreateLevel = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_create.png"));
		ImageIcon newBtnCreateLevel = new ImageIcon(buttonCreateLevel.getImage().getScaledInstance(310, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon buttonCreateLevelRollover = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_create_Rollover.png"));
		ImageIcon newBtnCreateLevelRollover = new ImageIcon(buttonCreateLevelRollover.getImage().getScaledInstance(310, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon buttonCreateLevelPressed = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_create_Pressed.png"));
		ImageIcon newBtnCreateLevelPressed = new ImageIcon(buttonCreateLevelPressed.getImage().getScaledInstance(310, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnCreateLevel = new JButton(newBtnCreateLevel);
		btnCreateLevel.setBounds(235, 250, 310, 69);
		btnCreateLevel.setHorizontalAlignment(SwingConstants.CENTER);
		btnCreateLevel.setBorderPainted(false);
		btnCreateLevel.setBackground(Color.WHITE);
		btnCreateLevel.setBorder(null);
		btnCreateLevel.setContentAreaFilled(false);
		btnCreateLevel.addActionListener(new CreateButtonController(blm));
		btnCreateLevel.setRolloverEnabled(true);
		btnCreateLevel.setRolloverIcon(newBtnCreateLevelRollover);
		btnCreateLevel.setPressedIcon(newBtnCreateLevelPressed);
		add(btnCreateLevel);
		
		JButton btnCreateLevel2 = new JButton();
		btnCreateLevel2.setBorder(null);
		btnCreateLevel2.setBounds(300, 250, 190, 50);

		ImageIcon backgroundImg = new ImageIcon(LevelBuilderMenuView.class.getResource("/sw/resource/image/splashScreen.png"));
		ImageIcon newBackground = new ImageIcon(backgroundImg.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		JLabel background = new JLabel(newBackground);
		background.setVerticalAlignment(SwingConstants.TOP);
		background.setBackground(Color.WHITE);
		background.setBounds(0, 0, 800, 600);
		add(background);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}

package sw.builder.gui.layout;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sw.app.gui.view.IView;
import sw.builder.gui.controller.CreateButtonController;

@SuppressWarnings("serial")
public class LevelBuilderMenuView extends JPanel implements IView {

	BuilderLayoutManager blm;
	

	public LevelBuilderMenuView(BuilderLayoutManager blm) {
		this.blm = blm;
		setLayout(null);
		initialize();
	}

	@Override
	public void initialize() {		
		JButton btnCreateLevel = new JButton();
		btnCreateLevel.setBorder(null);
		add(btnCreateLevel);
		btnCreateLevel.setBounds(300, 250, 190, 50);
		btnCreateLevel.setText("Create New Level");
		
		btnCreateLevel.addActionListener(new CreateButtonController(blm));

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

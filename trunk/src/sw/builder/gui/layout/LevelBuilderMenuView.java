package sw.builder.gui.layout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sw.app.gui.controller.CreditScreenController;
import sw.app.gui.controller.PlayGameScreenController;
import sw.app.gui.controller.ScoreboardScreenController;
import sw.app.gui.view.IView;
import sw.app.gui.view.LayoutManager;

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


		JLabel background = new JLabel();
		add(background);
		background.setBounds(0, 0, 800, 600);
		background.setIcon(new ImageIcon(
				"src/sw/resource/image/SixesWildMainMenuImage.png"));
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}

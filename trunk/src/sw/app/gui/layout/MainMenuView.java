package sw.app.gui.layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuView extends JPanel implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1717902879125448300L;
	LayoutManager lm;
	public MainMenuView(LayoutManager lm) {
		this.lm = lm;
		setLayout(null);
		initialize();
	}

	@Override
	public void initialize() {
		this.setBackground(Color.WHITE);
		JButton btnPlay = new JButton();
		add(btnPlay);
		btnPlay.setBounds(300, 150, 190, 50);
		btnPlay.setIcon(new ImageIcon("src/sw/resource/image/PlayButton.png"));
		
		JButton btnScoreboard = new JButton();
		add(btnScoreboard);
		btnScoreboard.setBounds(300, 225, 190, 50);
		btnScoreboard.setIcon(new ImageIcon("src/sw/resource/image/ScoreboardButton.png"));
		
		JButton btnCredits = new JButton();
		add(btnCredits);
		btnCredits.setBounds(300, 300, 190, 50);
		btnCredits.setIcon(new ImageIcon("src/sw/resource/image/CreditsButton.png"));
		
		
		
		btnPlay.addActionListener(new PlayGameScreenController(lm));
		btnScoreboard.addActionListener(new ScoreboardScreenController(lm));
		btnCredits.addActionListener(new CreditScreenController(lm));
		
	}
	
	public Dimension getPrefferredSize(){
		return new Dimension(800,600);
	}

	@Override
	public void cleanup() {
		
		
	}
}

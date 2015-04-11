package sw.app.gui.layout;

import javax.swing.JButton;
import javax.swing.JPanel;

import sw.app.gui.layout.board.BoardPanel;
import sw.app.gui.layout.board.GameInfoPanel;
import sw.app.gui.layout.board.PowerUpPanel;
import sw.app.gui.layout.board.ScorePanel;
import sw.app.gui.layout.board.TimeMovePanel;
import sw.common.model.controller.QuitButtonActionListener;
import sw.common.system.manager.LayoutManager;

public class GameplayView extends JPanel implements IView {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -7540685505032159107L;

	BoardPanel boardPanel = new BoardPanel();
	ScorePanel scorePanel = new ScorePanel();
	GameInfoPanel gameInfoPanel = new GameInfoPanel();
	TimeMovePanel timeMovePanel = new TimeMovePanel();
	PowerUpPanel powerUpPanel = new PowerUpPanel();
	JButton quitButton = new JButton();
	
	LayoutManager manager;
	
	/**
	 * Create the panel.
	 */
	public GameplayView(LayoutManager manager) {
		this.manager = manager;
		
		// Listens to quit button
		quitButton.addActionListener(new QuitButtonActionListener(manager));
		setLayout(null);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}

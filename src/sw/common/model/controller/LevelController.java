/**
 * @file LevelController.java
 * @date Apr 23, 2015 11:05:49 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Stack;
import java.util.TimerTask;

import sw.app.gui.view.IGameplayView;
import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.app.gui.view.board.IBoardPanel;
import sw.app.gui.view.board.IMovePanel;
import sw.app.gui.view.board.IScorePanel;
import sw.app.gui.view.board.ITimePanel;
import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.controller.IMove;
import sw.common.model.controller.IMode.MOVE_POLICY;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;
import sw.common.system.manager.TimerTaskManager;
/**
 * Class for the level contorller.
 */
public class LevelController implements ILevelController, IGameController, IMoveManager, IGameplayView {

	public final static String strFinished = "finished";
	public final static String strWon      = "won";

	// Refresh task
	final String refreshTask   = "GameplayRefresh";
	final int    refreshPeriod = 250; // msec
		
	Level lvl;
	IGameplayView gpv;	
	
	Game game;
	IMode mode;
	
	//Boolean hasFinished = false;
	Stack<IMove> moves = new Stack<IMove>();
	
	/**
	 * Construct a level controller.
	 * @param level the current level
	 * @param gpv the view for the level
	 */
	public LevelController(Level level, IGameplayView gpv) {		
		this.gpv = gpv;
		System.out.println(level);
		setLevel(level);		
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#setLevel(sw.common.model.entity.Level)
	 */
	public void setLevel(Level lvl) {
		this.lvl = lvl;
		game = this.lvl.getGame();
		mode = this.lvl.getMode();
		
		lvl.initialize(this);
		
		gpv.setLevel(lvl);
	}
	
	//////////////////////////////////////////////////////////
	// IMoveManager methods
	//
	
	public boolean pushMove(IMove move) {
		if (move.doMove()) {
			if (mode.getMovePolicy() == MOVE_POLICY.COUNT_UP) {
				game.getStats().setNumMoves(1);
			} else {
				game.getStats().setNumMoves(-1);	
			}
			
			moves.push(move);
			return true;
		}
		return false;
	}

	public boolean undoMove() {
		if (!moves.isEmpty()) {
			if (moves.peek().undoMove()) {
				if (mode.getMovePolicy() == MOVE_POLICY.COUNT_UP) {
					game.getStats().setNumMoves(-1);
				} else {
					game.getStats().setNumMoves(1);	
				}
				moves.pop();
				return true;
			}
		}
		return false;
	}

	public int countMove() {
		return game.getStats().getNumMoves();
	}

	public boolean updateScore(int delta) {
		game.getStats().setScore(delta);
		game.getStats().setStars(lvl.getStars());
		return true;
	}

	public boolean hasFinished() {
		return mode.hasFinished(game, lvl.getWinStats());
	}

	public void finishGame() {
		if (hasFinished()) {
			TimerTaskManager.cancelAll();
			
			Time t = getTimePanel().getTime();
			lvl.getGame().getStats().setTime(t);
			
			if (lvl.hasWon()) {
				SixesWildJFrame.getLevelManager().unlockNextLevel();
				
				LayoutManager.switchToPostGameView(true, lvl);
			} else {
				LayoutManager.switchToPostGameView(true, lvl);
			}
		}
	}
	
	//////////////////////////////////////////////////////////
	// IGameController methods
	//
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#setTime(java.sql.Time, boolean)
	 */
	@Override
	public void setTime(Time t, boolean countDown) {
		ITimePanel tp = gpv.getTimePanel();
		
		tp.stopTimer();
		tp.setTime(t);
		tp.setCountDown(countDown);		
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#setAlarm(java.sql.Time, java.awt.event.ActionListener)
	 */
	@Override
	public void setAlarm(Time t, ActionListener al) {
		gpv.getTimePanel().setAlarm(t, al);
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#updateGame()
	 */
	@Override
	public void updateGame() {
		if (game != null) {			
			Statistics stats = game.getStats();			
			
			gpv.getScorePanel().setScore(stats.getScore());
			gpv.getScorePanel().setStar(lvl.getStars());
			
			gpv.getMovePanel().setMove(stats.getNumMoves());
		}		
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#startGame()
	 */
	@Override
	public void startGame() {
		setBoardController(mode.getBoardController());
		
		// Start updating the Game statistics
		TimerTaskManager.scheduleTask(refreshTask, new TimerTask() {				
			@Override
			public void run() {
				updateGame();					
			}
		}, refreshPeriod);
		
		gpv.getTimePanel().startTimer();
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#pauseGame()
	 */
	@Override
	public void pauseGame() {
		gpv.getTimePanel().stopTimer();
		TimerTaskManager.cancelTask(refreshTask);		
	}

	//////////////////////////////////////////////////////////
	// ILevelController methods
	//
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.ILevelController#getMoveManager()
	 */
	@Override
	public IMoveManager getMoveManager() {
		return this;
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.ILevelController#getBoardLocator()
	 */
	@Override
	public IBoardLocationManager getBoardLocator() {
		return game.getBoard();
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.ILevelController#getBoardSelector()
	 */
	@Override
	public IBoardSelectionManager getBoardSelector() {
		return game.getBoard();
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.ILevelController#setBoardController(sw.common.model.controller.BoardController)
	 */
	@Override
	public void setBoardController(BoardController bc) {
		if (bc == null) {
			throw new IllegalArgumentException("Board controller is null!");
		}
		
		bc.initialize(this);
		gpv.getBoardPanel().setBoardController(bc);		
	}	
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.ILevelController#getGameController()
	 */
	@Override
	public IGameController getGameController() {
		return this;
	}
	
	//////////////////////////////////////////////////////////
	// IGameplayView methods
	//	
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.ILevelController#getLevel()
	 */
	@Override
	public Level getLevel() {
		return lvl;
	}	

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getScorePanel()
	 */
	@Override
	public IScorePanel getScorePanel() {
		return gpv.getScorePanel();
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getTimePanel()
	 */
	@Override
	public ITimePanel getTimePanel() {
		return gpv.getTimePanel();
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getMovePanel()
	 */
	@Override
	public IMovePanel getMovePanel() {
		return gpv.getMovePanel();
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getBoardPanel()
	 */
	@Override
	public IBoardPanel getBoardPanel() {
		return gpv.getBoardPanel();
	}	

}

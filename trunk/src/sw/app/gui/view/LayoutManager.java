package sw.app.gui.view;

import javax.swing.JPanel;

import sw.common.system.manager.LevelManager;


public class LayoutManager {

	SixesWildJFrame f;
	MainMenuView mmv;
	SplashScreenView ssv;
	GameplayView gv;
	CreditScreenView csv;
	ScoreBoardView sbv;
	PlayGameScreenView pgs;
	PostGameView pgv;
	
	JPanel current = null;
	
	public LayoutManager(SixesWildJFrame f){
		this.f = f;
		mmv = new MainMenuView(this);
		gv = new GameplayView(this, f.getLevelManager());
		csv = new CreditScreenView(this);
		sbv = new ScoreBoardView(this);
		pgs = new PlayGameScreenView(this, f.levelManager);
		pgv = new PostGameView(this, f.levelManager);
	}
	
	public LayoutManager(SixesWildJFrame_BoardPanel f){
		///this.f = f;
		mmv = new MainMenuView(this);
		//gv = new GameplayView(this, f.getLevelManager());
		csv = new CreditScreenView(this);
		sbv = new ScoreBoardView(this);
		pgs = new PlayGameScreenView(this, new LevelManager());
	}
	
	public void switchToMainMenu(){
		current = mmv;
		f.switchToScreen(mmv);
	}
	
	public void switchToGameplayView(){
		current = gv;
		f.switchToScreen(gv);
	}
	
	public void switchToScoreBoardView(){
		current = sbv;
		f.switchToScreen(sbv);
	}
	
	public void switchToCreditScreenView(){
		f.switchToScreen(csv);
	}
	
	public void switchToPlayView(){
		current = pgs;
		f.switchToScreen(pgs);
	}
	
	public void switchToPostGameView() {
		current = pgv;
		f.switchToScreen(pgv);
	}
	
	public JPanel getCurrentView() {
		return current;
	}
	
}

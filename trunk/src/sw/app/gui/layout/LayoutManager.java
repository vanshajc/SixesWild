package sw.app.gui.layout;


public class LayoutManager {

	SixesWildJFrame f;
	MainMenuView mmv;
	SplashScreenView ssv;
	GameplayView gv;
	CreditScreenView csv;
	ScoreBoardView sbv;
	PlayGameScreenView pgs;
	PostGameView pgv;
	
	public LayoutManager(SixesWildJFrame f){
		this.f = f;
		mmv = new MainMenuView(this);
		gv = new GameplayView(this, f.getLevelManager());
		csv = new CreditScreenView(this);
		sbv = new ScoreBoardView(this);
		pgs = new PlayGameScreenView(this);
		pgv = new PostGameView(this);
	}
	
	public LayoutManager(SixesWildJFrame_BoardPanel f){
		///this.f = f;
		mmv = new MainMenuView(this);
		//gv = new GameplayView(this, f.getLevelManager());
		csv = new CreditScreenView(this);
		sbv = new ScoreBoardView(this);
		pgs = new PlayGameScreenView(this);
	}
	
	public void switchToMainMenu(){
		System.out.println("Going to Main Menu");
		f.switchToScreen(mmv);
	}
	
	public void switchToGameplayView(){
		System.out.println("Going to gameplay view");
		f.switchToScreen(gv);
	}
	
	public void switchToScoreBoardView(){
		System.out.println("Going to score board view");
		f.switchToScreen(sbv);
	}
	
	public void switchToCreditScreenView(){
		System.out.println("Going to credit view");
		//TODO Need to make credit view object
		f.switchToScreen(csv);
	}
	
	public void switchToPlayView(){
		System.out.println("Going to play view");
		f.switchToScreen(pgs);
		//TODO Need to make play view object
	}
	
	public void switchToPostGameView() {
		System.out.println("Going to postgame view");
		f.switchToScreen(pgv);
	}
	
	
}

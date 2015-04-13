package sw.app.gui.layout;


public class LayoutManager {

	SixesWildJFrame f;
	MainMenuView mmv;
	SplashScreenView ssv;
	GameplayView gv;
	//CreditView cv;
	ScoreBoardView sbv;
	
	public LayoutManager(SixesWildJFrame f){
		this.f = f;
		mmv = new MainMenuView(this);
		//gv = new GameplayView();
		sbv = new ScoreBoardView(this);
	}
	
	void switchToMainMenu(){
		System.out.println("Going to Main Menu");
		f.switchToScreen(mmv);
	}
	
	void switchToGameplayView(){
		System.out.println("Going to gameplay view");
		f.switchToScreen(gv);
	}
	
	void switchToScoreBoardView(){
		System.out.println("Going to score board view");
		f.switchToScreen(sbv);
	}
	
	void switchToCreditView(){
		System.out.println("Going to credit view");
		//TODO Need to make credit view object
	}
	
	void switchToPlayView(){
		System.out.println("Going to play view");
		//TODO Need to make play view object
	}
	
	
	
	
}

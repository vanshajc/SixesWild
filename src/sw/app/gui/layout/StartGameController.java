package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartGameController implements ActionListener{
	LayoutManager lm;
	public StartGameController(LayoutManager lm){
		this.lm = lm;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lm.switchToGameplayView();
		
	}
	
	

}

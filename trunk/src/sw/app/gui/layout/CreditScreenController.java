package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditScreenController implements ActionListener {
	
	LayoutManager lm;
	
	public CreditScreenController(LayoutManager lm) {
		this.lm = lm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lm.switchToCreditView();
	}

}

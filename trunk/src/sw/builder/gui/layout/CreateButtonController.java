package sw.builder.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButtonController implements ActionListener {
	
	BuilderLayoutManager blm;

	public CreateButtonController(BuilderLayoutManager blm) {
		this.blm = blm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		blm.switchToLevelBuilder();

	}

}

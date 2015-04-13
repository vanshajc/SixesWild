package sw.app.gui.layout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostGameView extends JPanel implements IView{
	
	LayoutManager lm;
	public PostGameView(LayoutManager lm) {
		this.lm = lm;
		initialize();
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

		JButton btnMainmenu = new JButton("MainMenu");
		btnMainmenu.addActionListener(new MainMenuController(lm));
		
		JButton btnNextlevel = new JButton("NextLevel");
		
		JButton btnReplay = new JButton("Replay");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnMainmenu)
					.addGap(102)
					.addComponent(btnReplay)
					.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
					.addComponent(btnNextlevel)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(266, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMainmenu)
							.addComponent(btnNextlevel))
						.addComponent(btnReplay, Alignment.TRAILING))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

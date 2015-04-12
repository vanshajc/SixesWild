package sw.app.gui.layout.board;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class GameInfoPanel extends JPanel {
	JLabel info = new JLabel();
	
	public GameInfoPanel(String levelName) {
		info.setText(levelName);
		info.setHorizontalAlignment(JLabel.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(info, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(info)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805129288147207409L;
}

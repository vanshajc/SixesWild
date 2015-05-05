package sw.app.gui.view.board;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

/**
 * Class for representing the game info view.
 */
public class GameInfoPanel extends JPanel {
	JLabel info = new JLabel();
	
	public GameInfoPanel() {
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(200, 15));
		info.setForeground(new Color (184, 134, 11));
		info.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		info.setHorizontalAlignment(JLabel.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(info, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(info, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setLevelName(String name) {
		info.setText(name);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805129288147207409L;
}

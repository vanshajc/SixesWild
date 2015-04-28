/**
 * @file PowerUpPanel.java
 * @author Vanshaj Chowdhary, ANDREW PUT YOUR NAME HERE
 */
package sw.app.gui.view.board;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import sw.common.model.controller.PwrUpRemoveActionListener;
import sw.common.model.controller.PwrUpShuffleActionListener;
import sw.common.model.controller.PwrUpSwapActionListener;
import sw.common.model.entity.Game;
import sw.common.system.manager.CommonResourceManager;

/**
 * Class for the Powerup Panel on the game.
 */
public class PowerUpPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4058514218265371590L;
	JButton btnSwap;
	JButton btnShuffle;
	JButton btnRemove;
	
	public PowerUpPanel() {
		setOpaque(false);
		setBorder(null);
		
		CommonResourceManager crm = new CommonResourceManager();
		btnSwap = new JButton(new ImageIcon(PowerUpPanel.class.getResource(crm.getPowerUpImage("swap"))));
		btnSwap.addActionListener(new PwrUpSwapActionListener());
		
		
		btnShuffle = new JButton(new ImageIcon(PowerUpPanel.class.getResource(crm.getPowerUpImage("shuffle"))));
		btnShuffle.addActionListener(new PwrUpShuffleActionListener());
		
		btnRemove = new JButton(new ImageIcon(PowerUpPanel.class.getResource(crm.getPowerUpImage("remove"))));
		btnRemove.addActionListener(new PwrUpRemoveActionListener());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(400, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setPwrUp(Game game) {
		if (game.getPwrUps()[Game.PWRUP_REMOVE] == 0) {
			btnRemove.setEnabled(false);
		} else {
			btnRemove.setEnabled(true);
		}
		if (game.getPwrUps()[Game.PWRUP_SWAP] == 0) {
			btnSwap.setEnabled(false);
		} else {
			btnSwap.setEnabled(true);
		}
		if (game.getPwrUps()[Game.PWRUP_SHUFFLE] == 0) {
			btnShuffle.setEnabled(false);
		} else {
			btnShuffle.setEnabled(true);
		}
	}
	
}

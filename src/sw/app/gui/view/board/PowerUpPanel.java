/**
 * @file PowerUpPanel.java
 * @author Vanshaj Chowdhary, ANDREW PUT YOUR NAME HERE, Tony Vu
 */
package sw.app.gui.view.board;

import java.awt.Color;

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

/**
 * Class for the Powerup Panel on the game.
 */
public class PowerUpPanel extends JPanel {
	
	private static final long serialVersionUID = 4058514218265371590L;
	JButton btnSwap;
	JButton btnShuffle;
	JButton btnRemove;
	
	/** Variables for the location of the images */
	String btnSwapPath = "/sw/resource/image/button_swap.png";
	String btnSwapRolloverPath = "/sw/resource/image/button_swap_Rollover.png";
	String btnSwapPressedPath = "/sw/resource/image/button_swap_Pressed.png";
	String btnSwapSelectedPath = "/sw/resource/image/button_swap_Selected.png";
	ImageIcon buttonSwap = new ImageIcon(PowerUpPanel.class.getResource(btnSwapPath));
	ImageIcon newBtnSwap = new ImageIcon(buttonSwap.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonSwapRollover = new ImageIcon(PowerUpPanel.class.getResource(btnSwapRolloverPath));
	ImageIcon newBtnSwapRollover = new ImageIcon(buttonSwapRollover.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonSwapPressed = new ImageIcon(PowerUpPanel.class.getResource(btnSwapPressedPath));
	ImageIcon newBtnSwapPressed = new ImageIcon(buttonSwapPressed.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonSwapSelected = new ImageIcon(PowerUpPanel.class.getResource(btnSwapSelectedPath));
	ImageIcon newBtnSwapSelected = new ImageIcon(buttonSwapSelected.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	
	String btnShufflePath = "/sw/resource/image/button_shuffle.png";
	String btnShuffleRolloverPath = "/sw/resource/image/button_shuffle_Rollover.png";
	String btnShufflePressedPath = "/sw/resource/image/button_shuffle_Pressed.png";
	ImageIcon buttonShuffle = new ImageIcon(PowerUpPanel.class.getResource(btnShufflePath));
	ImageIcon newBtnShuffle = new ImageIcon(buttonShuffle.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonShuffleRollover = new ImageIcon(PowerUpPanel.class.getResource(btnShuffleRolloverPath));
	ImageIcon newBtnShuffleRollover = new ImageIcon(buttonShuffleRollover.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonShufflePressed = new ImageIcon(PowerUpPanel.class.getResource(btnShufflePressedPath));
	ImageIcon newBtnShufflePressed = new ImageIcon(buttonShufflePressed.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	
	String btnRemovePath = "/sw/resource/image/button_smash.png";
	String btnRemoveRolloverPath = "/sw/resource/image/button_smash_Rollover.png";
	String btnRemovePressedPath = "/sw/resource/image/button_smash_Pressed.png";
	ImageIcon buttonRemove = new ImageIcon(PowerUpPanel.class.getResource(btnRemovePath));
	ImageIcon newBtnRemove = new ImageIcon(buttonRemove.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonRemoveRollover = new ImageIcon(PowerUpPanel.class.getResource(btnRemoveRolloverPath));
	ImageIcon newBtnRemoveRollover = new ImageIcon(buttonRemoveRollover.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	ImageIcon buttonRemovePressed = new ImageIcon(PowerUpPanel.class.getResource(btnRemovePressedPath));
	ImageIcon newBtnRemovePressed = new ImageIcon(buttonRemovePressed.getImage().getScaledInstance(77, 77, java.awt.Image.SCALE_SMOOTH));
	
	/**
	 * Constructs a powerup panel
	 */
	public PowerUpPanel() {
		setOpaque(false);
		setBorder(null);
		
		//CommonResourceManager crm = SixesWildJFrame.getCommonResourceManager();
		//btnSwap = new JButton(new ImageIcon(PowerUpPanel.class.getResource(crm.getPowerUpImage("swap"))));
		btnSwap = new JButton(newBtnSwap);
		btnSwap.setBackground(Color.WHITE);
		btnSwap.setBorderPainted(false);
		btnSwap.setBorder(null);
		btnSwap.setContentAreaFilled(false);
		btnSwap.addActionListener(new PwrUpSwapActionListener());
		btnSwap.setRolloverEnabled(true);
		btnSwap.setRolloverIcon(newBtnSwapRollover);
		btnSwap.setPressedIcon(newBtnSwapPressed);
		btnSwap.setSelectedIcon(newBtnSwapPressed);
		
		//btnShuffle = new JButton(new ImageIcon(PowerUpPanel.class.getResource(crm.getPowerUpImage("shuffle"))));btnShuffle = new JButton(newBtnShuffle);
		btnShuffle = new JButton(newBtnShuffle);
		btnShuffle.setBackground(Color.WHITE);
		btnShuffle.setBorderPainted(false);
		btnShuffle.setBorder(null);
		btnShuffle.setContentAreaFilled(false);
		btnShuffle.addActionListener(new PwrUpShuffleActionListener());
		btnShuffle.setRolloverEnabled(true);
		btnShuffle.setRolloverIcon(newBtnShuffleRollover);
		btnShuffle.setPressedIcon(newBtnShufflePressed);
		btnShuffle.setSelectedIcon(newBtnShufflePressed);
		
		//btnRemove = new JButton(new ImageIcon(PowerUpPanel.class.getResource(crm.getPowerUpImage("remove"))));
		btnRemove = new JButton(newBtnRemove);
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBorderPainted(false);
		btnRemove.setBorder(null);
		btnRemove.setContentAreaFilled(false);
		btnRemove.addActionListener(new PwrUpRemoveActionListener());
		btnRemove.setRolloverEnabled(true);
		btnRemove.setRolloverIcon(newBtnRemoveRollover);
		btnRemove.setPressedIcon(newBtnRemovePressed);
		btnRemove.setSelectedIcon(newBtnRemovePressed);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(400, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	/**
	 * Sets the powerups
	 * @param game the current game
	 */
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

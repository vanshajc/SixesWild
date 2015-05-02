package sw.app.gui.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyComboBoxUI extends javax.swing.plaf.basic.BasicComboBoxUI {

	@Override
	protected JButton createArrowButton() {
		ImageIcon buttonArrow = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_comboBox.png"));
		ImageIcon newBtnArrow = new ImageIcon(buttonArrow.getImage().getScaledInstance(77, 53, java.awt.Image.SCALE_SMOOTH));
		ImageIcon buttonArrowRollover = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_comboBox_Rollover.png"));
		ImageIcon newBtnArrowRollover = new ImageIcon(buttonArrowRollover.getImage().getScaledInstance(77, 53, java.awt.Image.SCALE_SMOOTH));
		ImageIcon buttonArrowPressed = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_comboBox_Pressed.png"));
		ImageIcon newBtnArrowPressed = new ImageIcon(buttonArrowPressed.getImage().getScaledInstance(77, 53, java.awt.Image.SCALE_SMOOTH));
		JButton btnArrow = new JButton(newBtnArrow);
		
		btnArrow.setRolloverEnabled(true);
		btnArrow.setRolloverIcon(newBtnArrowRollover);
		btnArrow.setPressedIcon(newBtnArrowPressed);
		
		return btnArrow;
	}
}

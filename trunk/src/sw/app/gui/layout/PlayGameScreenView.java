package sw.app.gui.layout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PlayGameScreenView extends JPanel implements IView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LayoutManager lm;
	public PlayGameScreenView(LayoutManager lm) {
		this.lm = lm;
		initialize();
	}
	
	public void initialize() {
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new MainMenuController(lm));
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new PlayGameScreenController(lm));
		
		JLabel lblLevel = new JLabel("Level");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
					.addComponent(btnStartGame)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(lblLevel)
					.addGap(18)
					.addComponent(comboBox, 0, 155, Short.MAX_VALUE)
					.addGap(140))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack)
								.addComponent(btnStartGame))))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

package sw.app.gui.layout;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainMenuView extends JPanel implements IView{
	public MainMenuView() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnScoreboard = new JButton("Scoreboard");
		btnScoreboard.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCredits.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(162)
							.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(148)
							.addComponent(btnScoreboard))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(167)
							.addComponent(btnCredits)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addComponent(btnPlay)
					.addGap(30)
					.addComponent(btnScoreboard)
					.addGap(27)
					.addComponent(btnCredits)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}

	@Override
	public void initialize() {
		
		
	}

	@Override
	public void cleanup() {
		
		
	}
}

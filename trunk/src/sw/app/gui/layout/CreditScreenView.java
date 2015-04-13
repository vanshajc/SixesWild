package sw.app.gui.layout;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class CreditScreenView extends JPanel implements IView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LayoutManager lm;
	public CreditScreenView(LayoutManager lm) {
		this.lm = lm;
		initialize();
	}
	
	public void initialize() {
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new MainMenuController(lm));
		
		JLabel lblNewLabel = new JLabel("Vanshaj Chowdhary");
		lblNewLabel.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel label = new JLabel("Trung-Nghia Ngo Huynh");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel label_1 = new JLabel("Jessie Greg Johnson");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel label_2 = new JLabel("Tuan Quang Vu");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel label_3 = new JLabel("Steven Yevchak");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel label_4 = new JLabel("Dr. George Heineman");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Special Thanks to");
		lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 35));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(191)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(363))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(155)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(326, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(184)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(356, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNewLabel_1)
					.addContainerGap(306, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(204)
					.addComponent(label_4)
					.addContainerGap(334, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addGap(100))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(243))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addGap(11)
					.addComponent(label_1)
					.addGap(11)
					.addComponent(label_2)
					.addGap(11)
					.addComponent(label_3)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(label_4)
					.addGap(18)
					.addComponent(btnBack)
					.addGap(16))
		);
		setLayout(groupLayout);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

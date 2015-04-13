package sw.app.gui.layout;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		
		setPreferredSize(new Dimension(800,550));
		
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
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel label_4 = new JLabel("Dr. George Heineman");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("French Script MT", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Special Thanks to");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 35));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(319)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(319, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(289)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(288, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(318)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(318, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(321)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(320, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(331)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(330, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(269)
					.addComponent(lblNewLabel_1)
					.addContainerGap(268, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(317)
					.addComponent(label_4)
					.addContainerGap(317, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(735, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel)
					.addGap(11)
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
					.addGap(177)
					.addComponent(btnBack)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

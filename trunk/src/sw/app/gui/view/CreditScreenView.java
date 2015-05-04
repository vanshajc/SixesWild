package sw.app.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sw.app.gui.controller.MainMenuController;

@SuppressWarnings("serial")
public class CreditScreenView extends JPanel implements IView{
	
	ImageIcon background = new ImageIcon(CreditScreenView.class.getResource("/sw/resource/image/secondBackground.png"));
	ImageIcon newBackground = new ImageIcon(background.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));

	public CreditScreenView() {
		//initialize();
	}
	
	public void initialize() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 600));
		
		ImageIcon buttonBack = new ImageIcon(CreditScreenView.class.getResource("/sw/resource/image/button_back.png"));
		ImageIcon newBtnBack = new ImageIcon(buttonBack.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackRollover = new ImageIcon(CreditScreenView.class.getResource("/sw/resource/image/button_back_Rollover.png"));
		ImageIcon newBtnBackRollover = new ImageIcon(btnBackRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackPressed =  new ImageIcon(CreditScreenView.class.getResource("/sw/resource/image/button_back_Pressed.png"));
		ImageIcon newBtnBackPressed = new ImageIcon(btnBackPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnBack = new JButton(newBtnBack);
		btnBack.setBounds(20, 500, 227, 69);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(new MainMenuController());
		btnBack.setRolloverEnabled(true);
		btnBack.setRolloverIcon(newBtnBackRollover);
		btnBack.setPressedIcon(newBtnBackPressed);
		add(btnBack);

		ImageIcon title = new ImageIcon(CreditScreenView.class.getResource("/sw/resource/image/title_credits.png"));
		ImageIcon newTitle = new ImageIcon(title.getImage().getScaledInstance(227, 84, java.awt.Image.SCALE_SMOOTH));
		JLabel lblTitle = new JLabel(newTitle);
		lblTitle.setBounds(560, 480, 227, 84);
		add(lblTitle);
		
		JLabel lbl1 = new JLabel("Vanshaj Chowdhary");
		lbl1.setBounds(210, 100, 400, 36);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl1.setForeground(new Color(184, 134, 11));
		add(lbl1);
		
		JLabel lbl2 = new JLabel("Trung-Nghia Ngo Huynh");
		lbl2.setBounds(210, 150, 400, 36);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl2.setForeground(new Color(184, 134, 11));
		add(lbl2);
		
		JLabel lbl3 = new JLabel("Jessie Greg Johnson");
		lbl3.setBounds(210, 200, 400, 36);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl3.setForeground(new Color(184, 134, 11));
		add(lbl3);
		
		JLabel lbl4 = new JLabel("Tuan Quang Vu");
		lbl4.setBounds(210, 250, 400, 36);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl4.setForeground(new Color(184, 134, 11));
		add(lbl4);
		
		JLabel lbl5 = new JLabel("Steven Yevchak");
		lbl5.setBounds(210, 300, 400, 36);
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl5.setForeground(new Color(184, 134, 11));
		add(lbl5);
		
		JLabel lbl6 = new JLabel("Dr. George Heineman");
		lbl6.setBounds(210, 450, 400, 36);
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl6.setForeground(new Color(184, 134, 11));
		add(lbl6);
		
		JLabel lbl7 = new JLabel("Special Thanks to");
		lbl7.setBounds(210, 375, 400, 36);
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Forte", Font.PLAIN, 35));
		lbl7.setForeground(new Color(184, 134, 11));
		add(lbl7);
		
		/*
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(325)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(label)
					.addGap(18)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(label_2)
					.addGap(18)
					.addComponent(label_3)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(label_4)
					.addGap(55)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);*/
		
		setLayout(null);	
	}
	
	@Override
	public void cleanup() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(newBackground.getImage(), 0, 0, null);
	}
}

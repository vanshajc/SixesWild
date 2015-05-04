package sw.app.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sw.app.gui.controller.MainMenuController;

/**
 * Prepare the view for the Credits screen.
 * @file CreditScreenView.java
 * @author Trung-Nghia N. Huynh
 * Creation date: April 13, 2015 - 5:00 PM
 */

@SuppressWarnings("serial")

public class CreditScreenView extends JPanel implements IView{
	
	/** The background for the screen. */
	ImageIcon background;
	ImageIcon newBackground;
	String backgroundPath = "/sw/resource/image/secondBackground.png";
	
	/** The Back button. */
	JButton btnBack;
	ImageIcon buttonBack;
	ImageIcon newBtnBack;
	ImageIcon buttonBackRollover;
	ImageIcon newBtnBackRollover;
	ImageIcon buttonBackPressed;
	ImageIcon newBtnBackPressed;
	String backBtnPath = "/sw/resource/image/button_back.png";
	String backBtnRollover = "/sw/resource/image/button_back_Rollover.png";
	String backBtnPressed = "/sw/resource/image/button_back_Pressed.png";
	
	/** The title. */
	JLabel lblTitle;
	String titlePath = "/sw/resource/image/title_credits.png";
	
	/** The texts to be displayed. */
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	JLabel lbl5;
	JLabel lbl6;
	JLabel lbl7;
	
	/**
	 * CreditScreenView constructor.
	 */
	public CreditScreenView() {
		this.buttonBack = new ImageIcon(CreditScreenView.class.getResource(backBtnPath));
		this.newBtnBack = new ImageIcon(buttonBack.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		this.buttonBackRollover = new ImageIcon(CreditScreenView.class.getResource(backBtnRollover));repaint();
		this.newBtnBackRollover = new ImageIcon(buttonBackRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		this.buttonBackPressed =  new ImageIcon(CreditScreenView.class.getResource(backBtnPressed));
		this.newBtnBackPressed = new ImageIcon(buttonBackPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		
		this.background = new ImageIcon(CreditScreenView.class.getResource(backgroundPath));
		this.newBackground = new ImageIcon(background.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));		
	}
	
	/**
	 * Initialize the view for the credits screen.
	 */
	public void initialize() {
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(800, 600));

		btnBack = new JButton(newBtnBack);
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

		ImageIcon title = new ImageIcon(CreditScreenView.class.getResource(titlePath));
		ImageIcon newTitle = new ImageIcon(title.getImage().getScaledInstance(227, 84, java.awt.Image.SCALE_SMOOTH));
		lblTitle = new JLabel(newTitle);
		lblTitle.setBounds(560, 480, 227, 84);
		add(lblTitle);
		
		lbl1 = new JLabel("Vanshaj Chowdhary");
		lbl1.setBounds(210, 100, 400, 36);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl1.setForeground(new Color(184, 134, 11));
		add(lbl1);
		
		lbl2 = new JLabel("Trung-Nghia Ngo Huynh");
		lbl2.setBounds(210, 150, 400, 36);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl2.setForeground(new Color(184, 134, 11));
		add(lbl2);
		
		lbl3 = new JLabel("Jessie Greg Johnson");
		lbl3.setBounds(210, 200, 400, 36);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl3.setForeground(new Color(184, 134, 11));
		add(lbl3);
		
		lbl4 = new JLabel("Tuan Quang Vu");
		lbl4.setBounds(210, 250, 400, 36);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl4.setForeground(new Color(184, 134, 11));
		add(lbl4);
		
		lbl5 = new JLabel("Steven Yevchak");
		lbl5.setBounds(210, 300, 400, 36);
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl5.setForeground(new Color(184, 134, 11));
		add(lbl5);
		
		lbl6 = new JLabel("Dr. George Heineman");
		lbl6.setBounds(210, 450, 400, 36);
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("French Script MT", Font.PLAIN, 35));
		lbl6.setForeground(new Color(184, 134, 11));
		add(lbl6);
		
		lbl7 = new JLabel("Special Thanks to");
		lbl7.setBounds(210, 375, 400, 36);
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Forte", Font.PLAIN, 35));
		lbl7.setForeground(new Color(184, 134, 11));
		add(lbl7);
		
		setLayout(null);	
	}
	
	/**
	 * Remove everything.
	 */
	@Override
	public void cleanup() {
		// TODO Auto-generated method stub		
	}
	
	/**
	 * Draws the background for the credits screen.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(newBackground.getImage(), 0, 0, null);
	}
}

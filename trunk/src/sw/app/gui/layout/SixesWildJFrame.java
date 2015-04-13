package sw.app.gui.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SixesWildJFrame extends JFrame implements IView{
	/*
	public static void main(String[] args) {
		SixesWildJFrame swj = new SixesWildJFrame();

		swj.setVisible(true);
		swj.initialize();
	}*/


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LayoutManager lm = new LayoutManager(this);
	SplashScreenView ssv = new SplashScreenView(lm);
	//MainMenuView mmv = new MainMenuView(lm);
	Container pane = getContentPane();
	long startTime;

	public SixesWildJFrame() {
		/*
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1006, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 724, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.add(ssv);
		setSize(1060, 850);
		getContentPane().setLayout(groupLayout);*/
		
		
		this.setSize(800,600);
		this.setLayout(new BorderLayout());
		setResizable(false);
		this.setVisible(true);
		
		this.initialize();


	}

	@Override
	public void initialize() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(ssv);
		ssv.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				lm.switchToMainMenu();
			}
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

	@Override
	public void cleanup() {

	}
	
	void switchToScreen(JPanel screen){
		System.out.println("Switch to next screen");
		pane.removeAll();
		pane.add(screen);
		pane.revalidate();
		pane.repaint();
	}
	
	
}


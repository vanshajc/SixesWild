package sw.app.gui.layout;

import javax.swing.JFrame;

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
	SplashScreenView ssv = new SplashScreenView();
	MainMenuView mmv = new MainMenuView();
	
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
		this.setSize(1060,850);
		this.setVisible(true);
		this.initialize();
	

	}

	@Override
	public void initialize() {
		this.add(ssv);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println("Doing stuff?");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Switching to Main Menu View");
		this.add(mmv);
		
		
		
		
	}

	@Override
	public void cleanup() {
		
	}
}


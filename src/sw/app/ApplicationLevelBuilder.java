package sw.app;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sw.builder.gui.layout.LevelBuilderJFrame;


public class ApplicationLevelBuilder {
	
	/** Instance of the level builder application */
	private static LevelBuilderJFrame app;

	/** Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationLevelBuilder window = new ApplicationLevelBuilder();
					window.app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application. */
	public ApplicationLevelBuilder() {
		initialize();
	}

	/** Initialize the contents of the frame. */
	private void initialize() {
		app = new LevelBuilderJFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @return the frame created
	 */
	public static LevelBuilderJFrame getFrame(){
		return app;
	}
}


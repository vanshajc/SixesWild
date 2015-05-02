/**
 * @file Application.java
 * @author Vanshaj Chowdhary, Tony Vu
 */
package sw.app;

import java.awt.EventQueue;

import sw.app.gui.view.SixesWildJFrame;

public class Application {

	/** Instance of the Sixes Wild game application */
	SixesWildJFrame app;

	/** Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.app.setVisible(true);
				} catch (Exception e) {
					System.err.println("What the hell happened???");
				}
			}
		});
	}

	/** Create the application. */
	public Application() {
		initialize();
	}

	/** Initialize the contents of the frame. */
	private void initialize() {
		app = new SixesWildJFrame();
	}

}

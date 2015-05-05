/**
 * @file IView.java
 * @author Vanshaj Chowdhary, Tony Vu.
 */
package sw.app.gui.view;


/** The controlling interface for a view of the application */
public interface IView {

	/** Initialize the View, this method is called after View is created */
	void initialize();
	
	/** Clean up the View before switching to another View */
	void cleanup();
	
}

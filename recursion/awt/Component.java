package recursion.awt;

import list.List;

/**
 * A class representing an AWT component. 
 * @author Ryan Schwegel
 * @version October 1 2020
 */
public abstract class Component {
	String name;
	/** @return A list of all the Widgets making up this Component 
	 *  (and all Widgets in its Containers)  in any order */ 
	public abstract List<Widget>  getAllWidgets();
	
	/** Display the name of this Component; also display all the
    components which it contains, on separate lines.
	 */
	public abstract void show();
}

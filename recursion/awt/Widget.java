package recursion.awt;

import list.ArrayList;
import list.List;

/**
 * An implementation of Component
 * @author Ryan Schwegel
 * @version October 1 2020
 */
public class Widget extends Component {
	private WidgetType type;

	public Widget(String name, WidgetType type) {
		this.name = name;
		this.type = type; 
	}
	
	public List<Widget> getAllWidgets() {
		List<Widget> out = new ArrayList<Widget>();
		out.add(this);
		return out;
	}

	
	public void show() {
		System.out.println("    " + name);
	} 
	
	public String toString() {
		return name;
	}
}

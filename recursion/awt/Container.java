package recursion.awt;
import list.*;

/**
 * An implementaion of Component that contains other components
 * @author Ryan Schwegel
 * @version October 1 2020
 */
public class Container extends Component {
	List<Component> components;
	String name;
	public Container(String name) {
		this.name = name;
		components = new ArrayList<Component>();
	}
	
	/** Add the given Component to this Container 
	 * @param component component to be added
	 */
	public void addComponent(Component component) {
		components.add(component);
	}
	
	@Override
	public List<Widget> getAllWidgets() {
		List<Widget> out = new ArrayList<Widget>();
		for(int i = 0; i < components.size(); i++)
			out.addAll(components.get(i).getAllWidgets());
		return out;
	}
	
	@Override
	public void show() {
		System.out.println(name);
		Iterator<Component> it = components.iterator();
		while(it.hasNext()) {
			System.out.print("    ");
			it.next().show();
		}
	}
	
	public String toString() {
		return name;
	}
}

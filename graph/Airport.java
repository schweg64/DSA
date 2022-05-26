package graph;
/** An Airport has a name
 * @author sdb
 * @author Ryan Schwegel
 * @version (2020)
 */
public class Airport implements Comparable{
	String name;
	boolean visited = false;
	boolean isHub;
	public Airport(String name) {
		this.name = name;
		isHub = false;
	}
	
	public Airport(String name, boolean isHub) {
		this.name = name;
		this.isHub = isHub;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Airport))
			return false;
		Airport other = (Airport) obj;
		return name.equals(other.name);
	}
	
	public String toString() {
		return name + (isHub ? "*" : "");
	}
	
	public void setIsHub(boolean hub) {
		isHub = hub;
	}
	
	public boolean isHub() {
		return isHub;
	}
	
	public int compareTo(Object obj) {
		Airport other = (Airport)obj;
		return (isHub ? 1 : 0) - (other.isHub() ? 1 : 0);
	}
	
}

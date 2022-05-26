package graph;
/** A Direct FLight has an origin airport and a 
 * destination Airport
 * @author sdb
 * @author Ryan Schwegel
 * @version 2020
 */
public class Flight {
	Airport origin, destination;
	
	public Flight(Airport origin, Airport destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public String toString() {
		return "(" + origin + "->" + destination + ")";
	}
}

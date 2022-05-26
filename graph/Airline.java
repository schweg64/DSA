package graph;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import queue.*;
import list.*;
import map.*;
/** An Airline has a collection of direct Flights.
 * The Airline is capable of finding a path from an
 * origin Airport to a destination Airport.
 * @author sdb
 * @author Ryan Schwegel
 * @version 2020
 */
public class Airline {
	List<Flight> flights; 
	Map<String,Airport> map;
	
	public static void main(String[] args) {
		Airline airline = new Airline();
		
		airline.getFlights();
		System.out.println("Flights: " + airline.flights);
		System.out.println("Map: " + airline.map + "\n");
		//System.out.println("Path from PHL to SFO");
		//System.out.println(airline.path("PHL","SFO"));
		
		//System.out.println("Path from LAX to Paris");
		//System.out.println(airline.path("LAX","Paris"));
		
		//System.out.println("Path from SFO to PHL");
		//System.out.println(airline.path("SFO","PHL"));
		
		System.out.println("Path from CVG to Paris");
		System.out.println(airline.path("CVG","Paris") + "\n");
		
		
		airline.map.get("PHL").setIsHub(true);
		System.out.println("PHL is now a hub port" + "\n");
		System.out.println("Path from CVG to Paris");
		System.out.println(airline.path("CVG","Paris"));
	}
	
	/** Read the direct flights from a text file.
	 * Build the List of FLights, and a Map from 
	 * Airport names to Airports.
	 */
	private void getFlights() {
		File inFile = new File("flights.txt");
		map = new HashMap<String,Airport>();
		flights = new ArrayList<Flight>();
		try {
			Scanner scanner = new Scanner(inFile);
			String flight, origin, dest;
			Airport o,d;
			while(scanner.hasNextLine()) {
				flight = scanner.nextLine();
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];
				if(map.containsKey(origin))
					o = map.get(origin);
				else {
					o = new Airport(origin);
					map.put(origin, o);
				}
				if(map.containsKey(dest))
					d = map.get(dest);
				else {
					d = new Airport(dest);
					map.put(dest, d);
				}
				flights.add(new Flight(o,d));
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
	
	/**
	 * Find a path form the Airport with the name origin, to
	 * the Airport with the name dest, if possible.
	 * It need not be an optimal path.
	 * @return the path as a List of Airports, empty if
	 * no path is found.
	 */
	private List<Airport> path(String origin, String dest){
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		
		List<Airport> result = path(o,d);
		clearAirports();
		return result;
	}
	
	/** @return the path from the origin to dest */
	private List<Airport> path (Airport origin, Airport destination){
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		if(origin.equals(destination)) {
			result.add(origin);
			return result;
		}
		Airport port;
		QueueADT<Airport> queue = getDirect(origin);
		while(!queue.isEmpty()) {
			port = queue.remove();
			port.visited = true; 
			result = path(port,destination);
			if(result.size()>0) {
				result.add(0,origin);
				return result;
			}
		}
		return result;
	}
	
	/** @return a List of Airports which can be reached 
	 * directly from the given Airport, and which have not
	 * already been visited
	 */
	private QueueADT<Airport> getDirect(Airport from){
		QueueADT<Airport> result = new PriorityQueue<Airport>();
		Iterator<Flight> it = flights.iterator();
		Flight flight;
		while(it.hasNext()) {
			flight = it.next();
			if(flight.origin.equals(from) && ! flight.destination.visited) {
				result.add(flight.destination);
			}
		}
		return result;
	}
	
	/** Reset visited flag of every Airport */
	private void clearAirports() {
		Flight flight;
		Airport port;
		Iterator<Flight> it = flights.iterator();
		while(it.hasNext()) {
			flight = it.next();
			flight.origin.visited = false;
			flight.destination.visited = false;
		}
	}
}


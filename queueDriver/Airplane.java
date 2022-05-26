package queueDriver;


/**
 * An Airplane has a flight number, an arrival time, and a fuel level.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class Airplane implements Comparable
{  int flight;
   int arrivalTime;
   int fuelLevel;       // gallons of jet fuel remaining
   
   public Airplane (int arrival, int fuel, int flight)
   {    arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println (this);
        
    }
   
   public int compareTo(Object obj) {
	   Airplane other = (Airplane)obj;
	   if(fuelLevel<4 || other.fuelLevel<4) {
		   if(fuelLevel != other.fuelLevel)
			   return other.fuelLevel - fuelLevel; // this>other if other has more fuel, and fuel is low
	   }
	   return other.arrivalTime - arrivalTime; // this>other if other arrived later
   }
    
   public String toString(){
	   return "Flight #" + flight + ", " + "Arrival Time: " + arrivalTime +", " + "Fuel: " + fuelLevel;
   }
}

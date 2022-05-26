package hashDriver;

public class HomeTown {
	String name, state, zip; 
	
	public HomeTown(String name, String state, String zip) {
		this.name = name;
		this.state = state;
		this.zip = zip;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof HomeTown))
			return false;
		return ((HomeTown)obj).zip.equals(zip);
	}
	public String toString() {
		return name + ", " + state + " " + zip;
	}
	public int hashCode() {
		int code = 17;
		code = code*31 + zip.hashCode();
		return code;
	}
}

package hashDriver;

public class Student {
	String name, idNumber;
	int credits;
	HomeTown hometown;
	public Student(String name, String id, int credits, HomeTown hometown) {
		this.name = name;
		idNumber = id;
		this.credits=credits;
		this.hometown = hometown;
	}
	
	public int hashCode() {
		int code = 17;
		code = code*31 + credits;
		code = code*31 + name.hashCode();
		code = code*31 + hometown.hashCode();
		return code;
	}
	
	public String toString() {
		return name + " #" + idNumber + " " + credits + " " + hometown;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Student))
			return false;
		Student other = (Student)obj;
		return other.name.equals(name) && other.credits == credits && other.hometown.equals(hometown);
	}
}

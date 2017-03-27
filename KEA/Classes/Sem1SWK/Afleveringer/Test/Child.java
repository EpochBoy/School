public class Child{

	// String variabel
	private String name;

	// default constructor
	public Child(){}

	// my constructor
	public Child(String name){
		this.name = name;
	}

	// get method
	public String getName(){
		return name;
	}

	// set method
	public void setName(String name){
		this.name = name;
	}

	public String toString(){
		return "name = " + this.name;
	}

}
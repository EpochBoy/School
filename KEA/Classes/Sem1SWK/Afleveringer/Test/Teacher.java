public class Teacher{

	// teachers name
	private String name;
	// teachers salary
	private int hourlySalary;

	// default constructor
	public Teacher(){}


	// my constructor
	public Teacher(String name,int hourlySalary){
		this.name = name;
		this.hourlySalary = hourlySalary;
	}

	// get method for teacher's name
	public String getName(){
		return name;
	}

	// set method for teacher's name
	public void setName(String name){
		this.name = name;
	}

	// set method for teacher's salary
	public int getHourlySalary(){
		return hourlySalary;
	}

	// get method for teacher's salary
	public void setHourlySalary(int hourlySalary){
		this.hourlySalary = hourlySalary;
	}

	// Override toString
	public String toString(){
		return "name = " + this.name + ", hourlySalary = " +this.hourlySalary;
	}





}
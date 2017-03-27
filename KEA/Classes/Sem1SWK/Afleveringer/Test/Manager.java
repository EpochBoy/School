public class Manager{

	// manager's name
	private String name;
	// manager's budget
	private double salaryBudget;

	// default constructor
	public Manager(){}

	// my constructor
	public Manager(String name, double salaryBudget){
		this.name = name;
		this.salaryBudget = salaryBudget;
	}

	// get method for name
	public String getName(){
		return name;
	}

	//  set method for name
	public void setName(String name){
		this.name = name;
	}

	// get method for salarybudget
	public double getSalaryBudget(){
		return salaryBudget;
	}

	// set method for salarybudget
	public void setSalaryBudget(double salaryBudget){
		this.salaryBudget = salaryBudget;
	}

	public String toString(){
		return "name = "+this.name+", salarybudget = "+this.salaryBudget;
	}

}
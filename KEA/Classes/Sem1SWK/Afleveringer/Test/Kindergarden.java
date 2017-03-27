import java.util.ArrayList;

public class Kindergarden{

	private final Manager manager;
	private final ArrayList<Teacher> teachers;
	private final ArrayList<Child> children;
	//private double totalSalary = 0.0;

	//My Constructor
	public Kindergarden(){
		this.manager = new Manager();
		this.teachers = new ArrayList<Teacher>();
		this.children = new ArrayList<Child>();

		setManager("per JensEn", 50000);
    	setManager("Dyne Larsen", 10000.50);

		Child child = new Child("Lars Loekke");
    	Child child2 = new Child("Helle Thorning");
    	addChild(child);
    	addChild(child2);

    	Teacher teacher = new Teacher("Johanne Schmidt", 100);
    	Teacher teacher2 = new Teacher("Mette Frederiksen", 200);
    	addTeacher(teacher);
    	addTeacher(teacher2);

    	printChildren();
    	printTeacher();
    	System.out.println(calculateTotalSalary());
    	System.out.println(calculateAverageSalary());

	}

	// Methoad first converts managers name to lower case and then checks
	// that it doesn't equal to per jensen, which won't be hired. It then
	// then sets the manager for Kindergarden
	public void setManager(String name, double salarybudget){
		if(name.toLowerCase().equals("per jensen")){
			System.out.println("We don't hire Per Jensens");
		}else{
		this.manager.setName(name);
		this.manager.setSalaryBudget(salarybudget);
		System.out.println("I am the Manager and my name is: "+name+" and current operating budget is: "+salarybudget);
		}
	}

	// Method adds a child to children and checks that children doesn't
	// exceed 50 kids.
	public Boolean addChild(Child child){
		if(this.children.size() >= 50)
			return false;
		else
			this.children.add(child);
			return true;
	}

	// getter for arraylist children
	public ArrayList<Child> getChildren() {
  		return this.children;
	}

	// Prints our childs name
	public void printChildren(){
		for(Child c : this.children){
			System.out.println(c.getName());
		}
	}


	public ArrayList<Teacher> getTeachers(){
		return this.teachers;
	}

	// Add teacher to <Arraylist>teachers, make sure teacher salary doesn't
	// exceed 250 pr. hr. Also cecks that manager budget isn't exceeded
	public void addTeacher(Teacher teacher){
		if(teacher.getHourlySalary() + calculateTotalSalary() > manager.getSalaryBudget()){
			System.out.println("Sorry budget exceeded");
		}else if(teacher.getHourlySalary() > 250){
			System.out.println("Sorry, salary too high");
		}else{
		this.teachers.add(teacher);
	}
	}

	// Prints our teachers name
	public void printTeacher(){
		for(Teacher t : this.teachers){
			System.out.println("Teachers name: "+t.getName()+" & Salary is: "+t.getHourlySalary());
		}
	}


	// Method that calculates total salary of <ArrayList>teachers
	public int calculateTotalSalary(){
		int totalSalary = 0;
		for(Teacher t: this.teachers){
			if(t != null){ //Nullcheck unnecessary with ArrayList<>
				totalSalary += t.getHourlySalary();
			}
		}
		// enten dette der flytter vaerdien ud i klassen, ellsers metode i calcAVG
		//this.totalSalary = totalSalary;
		return totalSalary;
	}

	// Method that calculates average salary in Kindergarden

	public int calculateAverageSalary(){
		int averageSalary = calculateTotalSalary() / this.teachers.size();
		return averageSalary;

	}

}
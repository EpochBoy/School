public class Bike{

	public String color;
	public int gear;


	public Bike(String color, int gear){
		this.color = color;
		this.gear = gear;
		// System.out.println("I got "+gear+" gears.");
	}

	public String toString(){
		return "Color "+gear;
	}

	public void ride(){
		System.out.println("Riding a bike, yeah!");
	}

	public void setColor(String color){
		this.color=color;
	}

	public String getColor(){
		return color;
	}

	public void setGear(int gear){
		this.gear=gear;
	}

	public int getGear(){
		return gear;
	}
}

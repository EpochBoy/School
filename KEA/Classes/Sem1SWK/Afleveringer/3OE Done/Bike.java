public class Bike{

	private int gears;
	private String color;
	private boolean suspension;

	public Bike(){}

	public Bike(int gears, String color, boolean suspension){
		this.gears = gears;
		this.color = color;
		this.suspension = suspension;
	}

	public int getGears(){
		return gears;
	}

	public void setGears(int gears){
		this.gears = gears;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public boolean getSuspension(){
		return suspension;
	}

	public void setSuspension(boolean suspension){
		this.suspension = suspension;
	}

	public String toString(){
		return this.color +" "+ this.gears +" "+ this.suspension;
			}
}
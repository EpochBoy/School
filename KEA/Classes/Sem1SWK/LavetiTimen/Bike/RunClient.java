public class RunClient{

	public static void main(String[] args) {
		Bike b = new Bike("Blue", 5);
		Bike a = new Bike("Green", 12);
		b.setColor("Yellow and Red");
		a.setGear(24);
		System.out.println(b);
		System.out.println("The bike is "+b.color+" and has "+b.gear+" gears.");
		System.out.println("The bike is "+a.color+" and has "+a.gear+" gears.");
		b.ride();


	}
}
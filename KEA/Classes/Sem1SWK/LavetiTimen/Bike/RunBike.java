public class RunBike{
	
	public static void main(String[] args) {
		Bikeren bike = new Bikeren(12, "Blue");
		System.out.println("Bike has "+bike.getGears()+" gears and the color "+bike.getColor());
		// System.out.println(bike.class);
	}
}
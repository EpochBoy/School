import java.util.Arrays;

public class RunClient{


	public static void main(String[] args) {
		//String[] bikeArrayPrint = bikeArray();
		//printMyBikes(bikeArrayPrint);


		BikeShop bike = new BikeShop;

		Bike[] bikes = new Bike[4];

		Bike bike1 = new MountainBike(21, "Black", true);
		Bike bike2 = new RoadBike(7, "Cobalt", false);
		Bike bike3 = new Bike();
		Bike bike4 = new RoadBike(7, "Cobalt", false);

		bikes[0] = bike1;
		bikes[1] = bike2;
		bikes[2] = bike3;
		bikes[3] = bike4;

		System.out.println(bikes[0]);
		System.out.println(bikes[1]);
		System.out.println(bikes[2]);
		System.out.println(bikes[3]);

		//for(int i = 0; i<bikes.length; i++){
		//	System.out.println(bikes[i].getColor());
		//}

		for(Bike b: bikes){
			System.out.println(b.getColor());
		}

		BikeShop cont = new BikeShop();
		Bike[] bikeshop = cont.removeNulls(bikes);
		System.out.println(bikeshop.length);
		System.out.println(Arrays.toString(bikes));
	}
}
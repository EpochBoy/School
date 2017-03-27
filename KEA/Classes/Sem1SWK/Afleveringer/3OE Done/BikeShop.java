public class BikeShop extends Bike{


public Bike[] removeNulls(Bike[] bikes){

	//find amount of bikes in array
	int count = 0;
	//
	for(int i = 0; i<bikes.length; i++){
		if(bikes[i] instanceof Bike){
			count++;fefefe
		}
	}

	//create array with index based on count
	Bike[] bikeshop = new Bike[count];

	int index = 0;
	for(int i = 0; i < bikes.length; i++){
		if(bikes[i] instanceof Bike){
			bikeshop[index] = (Bike)bikes[i];
			index++;
		}
	}

	return bikeshop;
	//returns array Bikeshop
	}

}



/*

public static void printMyBikes(String[] strings){
	for(int i = 0; i < strings.length; i++){
		System.out.println(strings[i]);
		}
	}

public void addBike(){
}

}
*/
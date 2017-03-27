import java.util.ArrayList;

public class Util{

	public double average(ArrayList<Temperature> temperature){

		double sum = 0;

		for(double i = 0; i < temperature.length; i++){
			sum = sum + temperature[i];
		}

		double average = sum / temperature.length;

		System.out.println("Average temperature: "+average);

	}








}
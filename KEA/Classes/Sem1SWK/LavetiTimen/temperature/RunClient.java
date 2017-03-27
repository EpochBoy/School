import java.util.ArrayList;
import java.time.LocalDate;

public class RunClient{



	public static void main(String[] args) {

		LocalDate date1 = LocalDate.of(1987, 7, 8);
		LocalDate date2 = LocalDate.of(1982, 7, 8);
		System.out.println(date1);

		Temperature temp1 = new Temperature(7, date1);
		Temperature temp2 = new Temperature(8.1, date2);

		ArrayList<Temperature> temperature = new ArrayList<>();
		temperature.add(temp1);
		temperature.add(temp2);
		System.out.println("\n"+temperature.size());
	}


}
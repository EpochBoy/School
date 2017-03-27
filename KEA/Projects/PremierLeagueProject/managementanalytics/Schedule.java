//Made by Frederik Blixt
import java.util.ArrayList;

public class Schedule{

	public static ArrayList<Match> schedule = new ArrayList<Match>();
	
	   //adder match til schedule
	   public static void addMatch(Match match){
		   schedule.add(match);  
	   }
	   //Printer schedule
		public void printSchedule(){
			for(int i = 0; i < schedule.size(); i++){
				System.out.println(schedule.get(i));
			}
		}		
}
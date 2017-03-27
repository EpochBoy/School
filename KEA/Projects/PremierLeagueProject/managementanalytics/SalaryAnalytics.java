import java.util.ArrayList;

public class SalaryAnalytics{

	public double goalsVsSalary(ArrayList<Player> players){
		double d = 0;
      int g = 0;
      for(Player p: players){
         d = p.getSalary();
         g = p.getGoals();
      }
      return d / g;
	}
   
   public static double savesVsSalary(ArrayList<Player> players){
		double d = 0;
      int g = 0;
      for(Player p: players){
         d = p.getSalary();
         g = Keeper.getSaves();
      }
		return d / g;
	}
}
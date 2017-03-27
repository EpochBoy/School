public class Keeper extends Player{

// only included if it was a shot on goal.
private static int saves;

	public Keeper(String name, int wins, int losses, int draws, int salary,
               int position, int goals, int saves){
		super(name, wins, losses, draws, salary, position, goals);
		this.saves = saves;
	}


	public void setSaves(int saves){
    	this.saves = saves;
    }

	public static int getSaves(){
    	return saves;
    }

}
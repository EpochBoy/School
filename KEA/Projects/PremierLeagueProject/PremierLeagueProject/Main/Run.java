//Made by Fredrik Bjoerklund
package Main;
import Controller.FileOperations;
import View.InputReader;
import Controller.PlayerAnalytics;


public class Run{

	public static void main(String[] args) {
	FileOperations fo = new FileOperations();
	PlayerAnalytics pa = new PlayerAnalytics();

	//pa.printPlayers(fo.getPlayerData());
	//System.out.println(fo.getPlayerData());


		InputReader inputreader = new InputReader();
		while(true)
			inputreader.select();



	}
}
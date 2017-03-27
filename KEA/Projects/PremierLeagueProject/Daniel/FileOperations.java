import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import java.io.FileReader;

public class FileOperations{

	//ArrayList<Player> playerData = new ArrayList<>();

	public ArrayList<Player> getPlayerData(){

		// create ArrayList to store player data from file
		ArrayList<Player> playerData = new ArrayList<>();

		try{
			//Creates buffered reader object instance with a FileReader
			BufferedReader br = new BufferedReader(new FileReader("playerdata.txt"));

			//Read the first line from text file
			String fileData = br.readLine();

			//loops through file until all lines are read
			while(fileData != null){
				// use string.split to load a string array with the values of
				// each line of the file using a comma as data seperator
				// (delimiter)
				String[] token = fileData.split(",");

				// Assumes file has correct format, makes temp vars for data
				String tempname = token[0];
				//System.out.println(tempname);
				int tempwins = Integer.parseInt(token[1]);
				int templosses = Integer.parseInt(token[2]);
            int tempdraws = Integer.parseInt(token[3]);
				int tempsalary = Integer.parseInt(token[4]);
				int tempposition = Integer.parseInt(token[5]);
				int tempgoals = Integer.parseInt(token[6]);
				//System.out.println(tempgoals);

				// Creates temp instance of Player object and loads data in it
				Player tempPlayer = new Player(tempname,tempwins,templosses,
					tempsalary,tempposition,tempgoals,tempdraws);

				// adds temp instance of Player to playerData
				playerData.add(tempPlayer);

				// read next line before looping
				fileData = br.readLine();
				}
			// close file stream
			br.close();
		}// handle excpetions
		catch(FileNotFoundException fnfe){
			System.out.println("File not found");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}//Prints player data for each player.
		for (Player player : playerData){
			//System.out.println(player);
		}
		return playerData;
	}

}

/*
PlayerData

name
wins
losses
salary
position
goals
saves
*/

/*
Schedule
date
*/

/*
ht
ot
outcome
*/
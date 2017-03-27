//Class made by Fredrik Bjørklund

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
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
				Player tempPlayer = new Player(tempname,tempwins,templosses,tempdraws,
					tempsalary,tempposition,tempgoals);

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
		//for (Player player : playerData){
			//System.out.println(player);
		//}
		return playerData;
	}

	public ArrayList<Keeper> getKeeperData(){

		// create ArrayList to store player data from file
		ArrayList<Keeper> keeperData = new ArrayList<>();

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
				int tempsaves = Integer.parseInt(token[7]);
				//System.out.println(tempgoals);

				// Creates temp instance of Player object and loads data in it
				Keeper tempPlayer = new Keeper(tempname,tempwins,templosses,tempdraws,
					tempsalary,tempposition,tempgoals,tempsaves);

				// adds temp instance of Player to keeperData
				keeperData.add(tempPlayer);

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
		//for (Player player : keeperData){
			//System.out.println(player);
		//}
		return keeperData;
	}

	public void managerComments(){

		String fileName = "Comments.txt";
		Scanner scan = new Scanner(System.in);

		try {
			FileWriter fileWriter = new FileWriter("Comments.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter outFile = new PrintWriter(bufferedWriter);
			String input;
			input = scan.nextLine();
			bufferedWriter.write(input);
			bufferedWriter.close();
		}
		catch (IOException ex) {
			System.out.println("Error writing to file " +fileName);
		}
	}
}

/*
PlayerData

name
wins
losses
draws
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
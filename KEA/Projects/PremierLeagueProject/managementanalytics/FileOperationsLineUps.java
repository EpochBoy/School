//Class made by Fredrik Bjoerklund and modified for LineUpData.txt by Jonas Tvede Henriksen
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationsLineUps{

	public ArrayList<Match> getLineUpData(){

		// create ArrayList to store player data from file
		ArrayList<Match> matchData = new ArrayList<Match>();

		try{
			//Creates buffered reader object instance with a FileReader
			BufferedReader br = new BufferedReader(new FileReader("lineupdata.txt"));

			//Read the first line from text file
			String fileData = br.readLine();

			//loops through file until all lines are read
			while(fileData != null){
				// use string.split to load a string array with the values of
				// each line of the file using a comma as data seperator
				// (delimiter)
				String[] token = fileData.split(",");

				// Assumes file has correct format, makes temp vars for data
				String matchname = token[0];
				String htstrat = token[1];
            	String otstrat = token[2];
            	String outcome = token[3];
				// Creates temp instance of Player object and loads data in it
				Match newmatch = new Match(matchname, htstrat, otstrat, outcome);

				// adds match to playerData
				matchData.add(newmatch);

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
		return matchData;
	}
}
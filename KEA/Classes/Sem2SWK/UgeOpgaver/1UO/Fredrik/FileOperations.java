import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations{


	public ArrayList<GroceryItemOrder> getGroceryList(){

		// create ArrayList to store grocerydata data from file
		ArrayList<GroceryItemOrder> groceryData = new ArrayList<>();

		try{
			//Creates buffered reader object instance with a FileReader
			BufferedReader br = new BufferedReader(new FileReader("grocerydata.txt"));

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
				int tempquantity = Integer.parseInt(token[1]);
				int tempprice = Integer.parseInt(token[2]);


				// Creates temp instance of Grocery object and loads data in it
				GroceryItemOrder tempGrocery = new GroceryItemOrder(tempname,tempquantity,tempprice);

				// adds temp instance of grocery to groceryData
				groceryData.add(tempGrocery);

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
		}

		return groceryData;
	}

}
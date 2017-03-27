import java.util.Scanner;
import java.io.*;

public class Run
{
    public static void main(String[] args)
    {
        GroceryList groceryList = new GroceryArrayList();


            // add 10 items to grocerylist
            groceryList.add(new GroceryItemOrder("Milk", 1, 25));
            groceryList.add(new GroceryItemOrder("Carrots", 2, 50));
            groceryList.add(new GroceryItemOrder("Onions", 5, 10));
            groceryList.add(new GroceryItemOrder("Coffee", 2, 5));
            groceryList.add(new GroceryItemOrder("Bread", 5, 3));
            groceryList.add(new GroceryItemOrder("Sugar", 1, 5));
            groceryList.add(new GroceryItemOrder("Ginger", 6, 2));
            groceryList.add(new GroceryItemOrder("Ham", 1, 4));
            groceryList.add(new GroceryItemOrder("Soap", 2, 2));
            //groceryList.add(new GroceryItemOrder("Chocolate", 5, 1));

            // add 1 item more to see what happens
            //groceryList.add(new GroceryItemOrder("Apple", 5, 2));

            // add 1 more to see what happens
            //groceryList.add(new GroceryItemOrder("Cake", 4, 23));
        System.out.println(groceryList);

        System.out.println("The grocery list contains " + groceryList.size() + " elements.");
            //groceryList.add(, new GroceryItemOrder("Butter", 4, 68));
        groceryList.add(0, new GroceryItemOrder("Tea"));



        // Print out the size
        System.out.println("The grocery list contains " + groceryList.size() + " elements.");
        System.out.println();

        //Print out grocerylist, and it´s total cost
        System.out.println(groceryList);
        System.out.println(groceryList.getTotalCost());
        System.out.println();

        // create new grocerylist
        GroceryList groceryList2 = new GroceryArrayList();

        // read grocerylist items from file
        readFile("List.txt", groceryList2);


        // print out this grocerylist, and it´s total cost
        System.out.println(groceryList2);
        System.out.println(groceryList2.getTotalCost());
        System.out.println();


    }
    public static void readFile(String fileName, GroceryList groceryList)
    {
        try
        {
            Scanner file = new Scanner(new File(fileName));

            String name;
            int quantity;
            int pricePerUnit;

            while (file.hasNext()) {
                name = file.next();
                groceryList.add(new GroceryItemOrder(name));
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
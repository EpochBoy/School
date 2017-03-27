import java.util.Arrays;

public class TestGrocery{

    public static void main(String[] args) throws Exception {

        System.out.println("I read from .txt file and print:");
        FileOperations grocerydata = new FileOperations();
        System.out.println(grocerydata.getGroceryList());

        GroceryItemOrder[] groceryList = new GroceryItemOrder[10];
        GroceryList gl = new GroceryList();

        GroceryItemOrder canofmashedtomaoes = new GroceryItemOrder("Can of Mashed Tomaoes", 2, 5.5);
        GroceryItemOrder canofbeans = new GroceryItemOrder("Can of Beans", 2, 8.5);
        GroceryItemOrder banana = new GroceryItemOrder("Banana", 4, 4.9);
        GroceryItemOrder apple = new GroceryItemOrder("Apple", 6, 3.9);
        GroceryItemOrder salad = new GroceryItemOrder("Salad", 1, 10.4);
        GroceryItemOrder chickenbreast = new GroceryItemOrder("Chicken Breast", 1, 25.5);
        GroceryItemOrder eggs = new GroceryItemOrder("Eggs", 12, 34.9);
        GroceryItemOrder literofmilk = new GroceryItemOrder("Liter of Milk", 2, 9.9);
        GroceryItemOrder jarofspice = new GroceryItemOrder("Jar of Spice", 1, 30.8);
        GroceryItemOrder boxofcookies = new GroceryItemOrder("Box of Cookies", 1, 24.9);

        gl.addItem(groceryList, canofmashedtomaoes, 0);
        gl.addItem(groceryList, canofbeans, 1);
        gl.addItem(groceryList, banana, 2);
        gl.addItem(groceryList, apple, 3);
        gl.addItem(groceryList, salad, 4);
        gl.addItem(groceryList, chickenbreast, 5);
        gl.addItem(groceryList, eggs, 6);
        gl.addItem(groceryList, literofmilk, 7);
        gl.addItem(groceryList, jarofspice, 8);
        gl.addItem(groceryList, boxofcookies, 9);
        //gl.addItem(groceryList, canofmashedtomaoes, 10); <- uncomment to trigger exeption

        System.out.println("I am hardcoded");
        System.out.println(Arrays.toString(groceryList));

       /* gl.printItems(groceryList);

        System.out.println(gl.getTotalCost(groceryList));*/
    }
}
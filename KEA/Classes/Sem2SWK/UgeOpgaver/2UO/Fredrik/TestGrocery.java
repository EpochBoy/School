
public class TestGrocery{


public static void main(String[] args) {

	GroceryItemOrder[] groceryItem = new GroceryItemOrder[10];
	GroceryArrayList gl = new GroceryArrayList();

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


	gl.add(0, canofbeans);
	gl.add(1, salad);
	gl.add(2, chickenbreast);


	gl.get(1);

	gl.add(3, banana);
	System.out.println(gl);
	gl.remove(3);
	System.out.println(gl);

}


}
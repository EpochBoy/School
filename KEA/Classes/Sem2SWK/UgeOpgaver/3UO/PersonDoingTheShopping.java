
import java.util.Observer;


public class PersonDoingTheShopping implements Observer
{


	String shopper;

	public PersonDoingTheShopping(GroceryItemOrder obj, String shopper)
	{
		this.shopper=shopper;
		obj.addObserver(this);

	}

	public void notifyObservers()
	{
		System.out.println("ohh darn"+shopper+"i need to change my plans for"+((GroceryItemOrder)obj).getName());
	}








/*
	private String shopper;

	public PersonDoingTheShopping(Observable obj, String shopper)
	{
		this.shopper = shopper;
		obj.registerObservers(this);

	}

	@Override
	public void update(Observable obj)
	{
		System.out.println("Oh great, now i get to update my grocerylist!"+shopper+"Let me just change"+((GroceryItemOrder)obj).getName());
	}
*/
}
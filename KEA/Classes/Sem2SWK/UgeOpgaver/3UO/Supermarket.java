import java.util.Observer;


public class Supermarket implements Observer
{

	String supermarket;

	public Supermarket(GroceryItemOrder obj, String supermarket)
	{
		this.supermarket=supermarket;
		obj.addObserver(this);

	}

	public void notifyObservers()
	{
		System.out.println("Supermarket"+supermarket+"just changed"+((GroceryItemOrder)obj).getName());
	}









/*
	private String supermarket;

	public Supermarket(Observable obj, String shopper)
	{
		this.supermarket = supermarket;
		obj.registerObserver(this);

	}

	@Override
	public void update(Observable obj)
	{
		System.out.println("Alert alert:"+supermarket+"has changed:"+((GroceryItemOrder)obj).getName());
	}
*/




}
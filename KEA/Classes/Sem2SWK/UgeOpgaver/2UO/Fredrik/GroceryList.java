import java.lang.Exception;


public interface GroceryList{

public void addItem(GroceryItemOrder[] groceryList, GroceryItemOrder gio, int i)throws Exception;

public double getTotalCost(GroceryItemOrder[] groceryList);

public int size(int[] gl);

public int get(int target);

public void add(int index, GroceryItemOrder gio);

public void remove(int index);

}
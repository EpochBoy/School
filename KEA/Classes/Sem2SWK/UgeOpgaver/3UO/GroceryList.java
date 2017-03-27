/**
 * Created by signeborch on 15/02/16.
 */




public interface GroceryList
{

    void add(GroceryItemOrder g);

    void add(int index, GroceryItemOrder g);

    void remove(int index);

    GroceryItemOrder get(int index);

    int size();

    int getTotalCost();


}
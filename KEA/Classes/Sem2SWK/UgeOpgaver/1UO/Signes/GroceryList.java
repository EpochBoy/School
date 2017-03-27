
public class GroceryList
{
    private GroceryItemOrder[] itemOrders = new GroceryItemOrder[10];
    private int numItems = 0;


    public void add(GroceryItemOrder item) throws Exception
    {
        if (numItems < 10)
        {
            itemOrders[numItems] = item;
            numItems++;
        }
        else
        {

            throw new Exception("List is full. Cannot add item " + item);

        }
    }

    public int getTotalCost()
    {
        int sum = 0;

        for (int i = 0; i < numItems; i++) {
            sum += itemOrders[i].getCost();
        }

        return sum;
    }

    public String toString()
    {
        String s = "";

        for (int i = 0; i < numItems; i++) {
            s += itemOrders[i] + "\n";
        }

        return s;
    }

}
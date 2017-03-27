
import java.util.Observable;



public class GroceryArrayList extends Observable implements GroceryList
{

/*
    private ArrayList<Observer> observers = new ArrayList();
    private GroceryItemOrder currentItem;
*/

    private GroceryItemOrder[] itemOrders = new GroceryItemOrder[10];
    private int numItems = 0;


    public void add(GroceryItemOrder item)
    {
        if (numItems < itemOrders.length)
        {
            itemOrders[numItems] = item;
            numItems++;
        }
        else
        {
            extendCapacity();
            itemOrders[numItems] = item;
            numItems++;
        }
        notifyObservers();
    }

    //pre : 0 <= index <= numItems
    public void add(int index, GroceryItemOrder item) {

        if (numItems < itemOrders.length)
        {
            for (int i = numItems; i > index; i--)
            {
                itemOrders[i] = itemOrders[i - 1];
            }

            itemOrders[index] = item;
            numItems++;
        }
        else
        {
            extendCapacity();
            for (int i = numItems; i > index; i--)
            {
                itemOrders[i] = itemOrders[i - 1];
            }

            itemOrders[index] = item;
            numItems++;
        }
    }

    private void extendCapacity()
    {
        GroceryItemOrder[] tempArray = new GroceryItemOrder[itemOrders.length * 2];

        for(int i = 0; i<itemOrders.length; i++)
        {
            tempArray[i] = itemOrders[i];
        }
        itemOrders = tempArray;
    }

    //pre : 0 <= index < numItems
    public void remove(int index) {
        for (int i = index; i < numItems; i++) {
            itemOrders[i] = itemOrders[i + 1];
        }

        numItems--;
        notifyObservers();
    }

    //pre : 0 <= index < numItems
    public GroceryItemOrder get(int index)
    {
      return itemOrders[index];
    }

    public int size() {
        return numItems;
    }


    public int getTotalCost()
    {
        int sum = 0;

        for (int i = 0; i < numItems; i++) {
            sum += itemOrders[i].getCost();
        }

        return sum;
    }

    @Override
    public String toString()
    {
        String s = "";

        for (int i = 0; i < numItems; i++) {
            s += itemOrders[i] + "\n";
        }

        return s;
    }

/*
    public void addObserver(Observer obj)
    {
        observers.add(obj);
    }

    public void notifyObservers(Observer obj)
    {
        for (int i=0; i<observers.size(); i++)
            observers.get(i).update(this);
    }



*/





/*
    @Override
    public void registerObserver(Observer obj)
    {
        if(obj == null) throw new NullPointerException("Observer has Null value, cannot compute");
        if(!itemOrders.contains(obj))
            itemOrders.add(obj);
    }


    @Override
    public void removeObserver(Observer obj)
    {
        itemOrders.remove(obj);
    }


    @Override
    public void notifyObservers()
    {
        for (int i=0; i< itemOrders.length(); i++ )
            itemOrders.get(i).update(this);
    }


    public GroceryItemOrder getCurrenItem()
    {
        return currentItem;
    }


    public void setCurrenItem(GroceryItemOrder currentItem)
    {
        System.out.println("Current grocery item is:"+ currentItem);
        this.currentItem = currentItem;

        notifyObservers();
    }
*/
}
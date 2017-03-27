package TableViewGroceries;


public class GroceryItemOrder
{


    private String name;
    private int quantity;
    private Double pricePerUnit;

    public GroceryItemOrder(String name)
    {
        this(name, 1, 0.0);
    }

    public GroceryItemOrder(String name, int quantity, Double pricePerUnit)
    {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName()
    {
        return this.name;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public Double getPricePerUnit()
    {
        return this.pricePerUnit;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setPricePerUnit(Double pricePerUnit)
    {
        this.pricePerUnit = pricePerUnit;
    }

    public int getCost()
    {

        return (int) (quantity * pricePerUnit);
    }

    public String toString()
    {
        return name + " " + quantity + " " + getCost();
    }
}
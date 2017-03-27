import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class GroceryItemOrder{

    private SimpleStringProperty name;
    private SimpleIntegerProperty quantity;
    private SimpleDoubleProperty pricePerUnit;

    public GroceryItemOrder(String name)
    {
        this(name, 1, 0.0);
    }

    public GroceryItemOrder(String name, int quantity, double pricePerUnit)
    {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.pricePerUnit = new SimpleDoubleProperty(pricePerUnit);
    }

    public String getName(){
        return name.get();
    }

     public void setName(String name){
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty(){
        return name;
    }

    public int getQuantity(){
        return quantity.get();
    }

    public void setQuantity(int quantity){
        this.quantity.set(quantity);
    }

    public SimpleIntegerProperty quantityProperty(){
        return quantity;
    }

    public double getPricePerUnit(){
        return pricePerUnit.get();
    }

    public void setPricePerUnit(double pricePerUnit){
        this.pricePerUnit.set(pricePerUnit);
    }

    public SimpleDoubleProperty pricePerUnitProperty(){
        return pricePerUnit;
    }

    public int getCost(){
        return (int) (getQuantity() * getPricePerUnit());
    }

    public String toString(){
        return name + " " + quantity + " " + getCost();
    }
}
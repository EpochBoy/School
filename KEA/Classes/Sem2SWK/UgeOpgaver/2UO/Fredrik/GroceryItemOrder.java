public class GroceryItemOrder{

private String itemname;
private int itemquantity;
private double itemprice;
private double itemcost;

   public GroceryItemOrder(String itemname, int itemquantity, double itemprice){
      this.itemname = itemname;
      this.itemquantity = itemquantity;
      this.itemprice = itemprice;
   }

   public void setItemName(){
      this.itemname = itemname;
   }

   public void setItemQuantity(){
      this.itemquantity = itemquantity;
   }

   public void setItemPrice(){
      this.itemprice = itemprice;
   }

   public String getItemName(){
      return itemname;
   }

   public int getItemQuantity(){
      return itemquantity;
   }

   public double getItemPrice(){
      return itemprice;
   }

   public String toString(){
      return getItemName() + ", " + getItemQuantity() + ", " +
      getCost() + ".";
   }

   public double getCost(){
      itemcost = getItemQuantity() * getItemPrice();
      return itemcost;
   }
}
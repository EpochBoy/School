import java.lang.Exception;



public class GroceryList{

   public void addItem(GroceryItemOrder[] groceryList, GroceryItemOrder gio, int i)throws Exception{
      int counter = 0;
      for(GroceryItemOrder kek: groceryList){
         counter ++;
      }if(counter != 11){
         groceryList[i] = gio;
      }else{
         throw new Exception();
      }
   }

   public double getTotalCost(GroceryItemOrder[] groceryList){
      double totalcost = 0.0;
      for(GroceryItemOrder kek: groceryList){
         totalcost += kek.getCost();
      }
      return totalcost;
   }





 /*
 public void printItems(){
      for(GroceryItemOrder kek: groceryList){
         System.out.println(kek.getItemName());
      }

   }

   public String toString(){
      return "The items currently on the grocerylist are: " + printItems();
   }
   */
}
import java.lang.Exception;


public class GroceryArrayList implements GroceryList{

private int count = 0;
private GroceryItemOrder[] groceryList;



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

	public int size(int[] gl){
		for(int i : gl){
			if(i>0){
			count++;
			}
		}
		return count;
	}

	public int get(int target){
		for(int i = 0; i < count; i++){
			if(count == target){
			return i;
			}
		}
		return -1;
	}

	public void add(int index, GroceryItemOrder gio){
		for(int i = count;i >= index + 1; i--){
			groceryList[i] = groceryList[i - 1];
		}
		groceryList[index] = gio;
		count++;

	}

	public void remove(int index){
		for(int i = index; i < count - 1; i++){
			groceryList[i] = groceryList[i+1];
		}
		count--;
	}



}
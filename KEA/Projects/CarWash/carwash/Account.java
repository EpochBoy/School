import java.util.ArrayList;

public class Account
{
   private int ID;
   private int saldo;
   private String name;
   ArrayList<String> history = new ArrayList<>();
   
   public Account(int id, String name)
   {
      this.name = name;
      this.ID = id;
   }
   
   public int getID()
   {
      return this.ID;
   }
   
   public String getName()
   {
      return this.name;
   }   
   
   public int getSaldo()
   {
      return this.saldo;
   }
   
   public void addToSaldo(int saldo)
   {
      if(saldo > 0 && saldo <= 1000)
      {
         history.add("You added "+saldo +" to your account. New account balance: "+(this.saldo + saldo));
         this.saldo =  this.saldo + saldo;
         System.out.println(saldo + " was added to your account balance. new account balance: " +this.saldo);
      }
      else
      {
         System.out.println("only amounts between 0-1000 are accepted");
      }        
   }
   
   public void makePurchase(int price)
   {
      history.add("You purchased a carwash that cost " + price +". New account balance: " + (this.saldo - price));
      this.saldo = this.saldo - price;
   }   
   
   public void printHistory()
   {
      System.out.println("Account History: \n");
      for(int i = 0; i < history.size(); i++)
      {
         System.out.println(history.get(i));
      }
      System.out.println("");
   }      
}   
             
   
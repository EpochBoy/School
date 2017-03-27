import java.util.ArrayList;

public class AccountManager
{
   ArrayList<Account> AccList = new ArrayList<>();
   
   public Account getAcc(String input)
   {
      int ID = Integer.parseInt(input);
      for(int i = 0; i < AccList.size(); i++)
      {
         if(AccList.get(i).getID() == ID)
         {
            return AccList.get(i);
         }
      }
      return null;
   }
   
   public void createAcc(String name)
   {
      Account A = new Account(AccList.size(), name);
      AccList.add(A);
   }   
}            
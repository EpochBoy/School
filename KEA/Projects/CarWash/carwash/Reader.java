import java.util.Scanner;

public class Reader
{
   private Scanner scan;
   private String user;
   private String input;
   private Account userAcc;
   
   public Reader()
   {
      scan = new Scanner(System.in);
   }
   
   public void initReader(AccountManager A)
   {
      //make some customers!
      A.createAcc("Bob");
      A.createAcc("Steve");
      A.createAcc("Sally");
      A.createAcc("George Bush");
      while(true)
      {
         if(userAcc == null)
         {
            System.out.println("Input customerID");
         
            user = scan.nextLine();
            try
            {
               userAcc = A.getAcc(user);
               if(userAcc != null)
               {
                  System.out.println("Welcome " +userAcc.getName() +" you have " +userAcc.getSaldo() +" kr on your account \nPlease choose a wash: \n1: Bronze  price: 200 \n2: Silver  price: 300 \n3: Gold  price: 400 \n4: add money to account \n5: view accounthistory \n6: Logout");
               }
            }
            catch(NumberFormatException e)
            {
               System.out.println("bad");
            }      
         }   
         if(userAcc != null)
         {
            System.out.println("type info to show menu");
            input = scan.nextLine();
            if(input.equals("info"))
            {
               System.out.println("Welcome " +userAcc.getName() +" you have " +userAcc.getSaldo() +" kr on your account \nPlease choose a wash: \n1: Bronze  price: 200 \n2: Silver  price: 300 \n3: Gold  price: 400 \n4: add money to account \n5: view accounthistory \n6: Logout");
            }
            if(input.equals("1"))
            {
               if(userAcc.getSaldo() > 200)
               {
                  userAcc.makePurchase(200);
                  System.out.println("Your car got a bronze wash. new account balance: " +userAcc.getSaldo());
               }
               else
               {
                  System.out.println("not enough money");
               }
            }  
            if(input.equals("2"))
            {
               if(userAcc.getSaldo() > 300)
               {
                  userAcc.makePurchase(300);
                  System.out.println("Your car got a silver wash. new account balance: " +userAcc.getSaldo());
               }
               else
               {
                  System.out.println("not enough money");
               }
            }  
            if(input.equals("3"))
            {
               if(userAcc.getSaldo() > 400)
               {
                  userAcc.makePurchase(400);
                  System.out.println("Your car got a gold wash. new account balance: " +userAcc.getSaldo());
               }
               else
               {
                  System.out.println("not enough money");
               }
            }       
            if(input.equals("4"))
            {
               System.out.println("How much money do you want to add?");
               input = scan.nextLine();
               userAcc.addToSaldo(Integer.parseInt(input));
               
            }   
            if(input.equals("5"))
            {
               userAcc.printHistory();
            }   
            if(input.equals("6"))
            {
               userAcc = null;
            }   
         }
      }     
   }    
}        
//Class made by Fredrik Bjoerklund, swtich case 2 added by Jonas Tvede Henriksen
package View;
import Controller.FileOperations;
import Controller.FileOperationsLineUps;
import Controller.LineUpAnalytics;
import Controller.PlayerAnalytics;
import Controller.SalaryAnalytics;

import java.util.Scanner;

public class InputReader{

private Scanner input = new Scanner(System.in);
FileOperations fo = new FileOperations();
FileOperationsLineUps folu = new FileOperationsLineUps();
SalaryAnalytics sa = new SalaryAnalytics();
PlayerAnalytics pa = new PlayerAnalytics();
LineUpAnalytics lua = new LineUpAnalytics();

   public void select(){
   	System.out.println("\nWelcome to Management Analytics\n");
   	System.out.println(
         "Conduct analysis & view: \n\n" +
         " 1. Cost of a goal\n" +
         " 2. Most efficient lineup\n" +
         " 3. Top 3 players measured by highest win/ratio\n"+
         " 4. Manager Comments\n"+
         " 5. Exit system\n"
   	);

   	int menuselect = input.nextInt();
   	input.nextLine();

      switch(menuselect){
         case 1:
            System.out.println("Salaries divided by goal count of the team's players: \n");
            pa.printPlayers(fo.getPlayerData());
            break;
         //Case 2 made by Jonas Tvede Henriksen.
         case 2:
            //Writes a message for the user of the program.
            System.out.println("Write the name of an opposing to get the number of wins against it using offensive strategy");
            //Creates a scanner on the next line for the user to utilize.
            String teamname = input.next();
            //If statements writing a message as well as calling different methods from the LineUpAnalytics class.
            if(teamname.equalsIgnoreCase("Norwich")){
               System.out.println("Number of matches won against Norwich with offensive line up: "
                + lua.offensiveStratWinsVsNorwich(folu.getLineUpData()));
            }
            if(teamname.equalsIgnoreCase("Chelsea")){
               System.out.println("Number of matches won against Chelsea with offensive line up: "
                + lua.offensiveStratWinsVsChelsea(folu.getLineUpData()));
            }
            if(teamname.equalsIgnoreCase("ManchesterCity")){
               System.out.println("Number of matches won against Manchester City with offensive line up: "
                + lua.offensiveStratWinsVsManchesterCity(folu.getLineUpData()));
            }
            break;
         case 3:
         //case 3 made by Frederik Blixt
            System.out.println("The top 3 players are:");
            pa.topThree();
            break;
         case 4:
            System.out.println("Add your comment please: \n");
            fo.managerComments();
            break;
         case 5:
            this.exit();
            break;
         default:
            System.out.println("\nNot an option. Returning to menu.\n\n");
            break;
         }
      }

   private void exit(){
   	System.out.println("\nClosing Management Analytics\n");
   	System.exit(1);
   }

   private void salaryanalytics(){}
   private void lineupanalytics(){}

   FileOperations fileoperations = new FileOperations();

   private void playeranalytics(){
   	System.out.println(fileoperations.getPlayerData());
   }
}
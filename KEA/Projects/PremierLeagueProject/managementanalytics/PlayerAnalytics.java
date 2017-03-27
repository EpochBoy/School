//Class made by Daniel Refn
import java.util.ArrayList;

public class PlayerAnalytics{
   FileOperations fo = new FileOperations();

   public PlayerAnalytics(){}

   //Player player = new Player();

   //ArrayList<Player> playerArray = new ArrayList<Player>();

   //Tilfoejer en spiller til truppen
   //playerArray.add();

   //Printer alle spillere i truppen
   public static void printPlayers(ArrayList<Player> players){
      for(Player p: players){
         System.out.println(p.getName()+ " " + Math.round(p.getSalary()
         / (double)p.getGoals()*100.0)/100.0);
      }
   }
   //Udregner en spillers win ratio(%-vis vundne kampe)
   public static double winRatio(Player player){
          return (0.0+player.getWins())/player.getMatches();
   }
   //Finder den spiller i truppen med bedste winRatio.
   public Player maxWinRatio(ArrayList<Player> players){
      if(players.size()>0){
      Player maxWinRatio = players.get(0);
         for(Player p: players){
            if((p.getWins()+0.0000001)/(p.getWins()+p.getLosses()+p.getDraws())
               >(maxWinRatio.getWins()+0.0000001)/(maxWinRatio.getWins()
               +maxWinRatio.getLosses()+maxWinRatio.getDraws())){
               maxWinRatio = p;
            }
         }
      return maxWinRatio;
      }
      return null;
   }

    public Player secondWinRatio(ArrayList<Player> players){

      if(players.size()>0){
      Player secondWinRatio = players.get(0);
         for(Player p: players){
            if(p != maxWinRatio(players) && (p.getWins()+0.0)
               /(p.getWins()+p.getLosses()+p.getDraws())>(secondWinRatio.getWins()+0.0)
               /(secondWinRatio.getWins()+secondWinRatio.getLosses()
               +secondWinRatio.getDraws())){
               secondWinRatio = p;

            }
         }
      return secondWinRatio;
      }
      return null;
   }

   public Player thirdWinRatio(ArrayList<Player> players){
      if(players.size()>0){
      Player thirdWinRatio = players.get(0);
         for(Player p: players){
            if(p != maxWinRatio(players) && p != secondWinRatio(players)
             && (p.getWins()+0.0)/(p.getWins()+p.getLosses()+p.getDraws())>(thirdWinRatio.getWins()+0.0)
               /(thirdWinRatio.getWins()+thirdWinRatio.getLosses()
               +thirdWinRatio.getDraws())){
               thirdWinRatio = p;
            }
         }

      return thirdWinRatio;
      }

      return null;
   }


   public void topThree(){
      System.out.println(maxWinRatio(fo.getPlayerData()).getName()
      +" "+Math.round(winRatio(maxWinRatio(fo.getPlayerData()))*100.0)/100.0);
      System.out.println(secondWinRatio(fo.getPlayerData()).getName()
      +" "+Math.round(winRatio(secondWinRatio(fo.getPlayerData()))*100.0)/100.0);
      System.out.println(thirdWinRatio(fo.getPlayerData()).getName()
      +" "+Math.round(winRatio(thirdWinRatio(fo.getPlayerData()))*100.0)/100.0);

   }


}
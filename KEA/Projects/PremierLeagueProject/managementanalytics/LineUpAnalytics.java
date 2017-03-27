//Class made by Jonas Tvede Henriksen.
import java.util.ArrayList;

public class LineUpAnalytics{
   
   //A method returning the number of Offensive-Offensive line-up match wins of the home team when facing Norwich.
   public static int offensiveStratWinsVsNorwich(ArrayList<Match> playedMatches){
      int counter = 0;
         for(Match m: playedMatches){
            if(m.getMatchName().equals("Home Team vs Norwich") && m.getHtStrat().equals("Offensive")
               && m.getOtStrat().equals("Offensive") && m.getOutcome().equals("Win")){
               counter++;
            }
         }
         return counter;
   }
   
   //A method returning the number of Offensive-Offensive line-up match wins of the home team when facing Chelsea.
   public static int offensiveStratWinsVsChelsea(ArrayList<Match> playedMatches){
      int counter = 0;
         for(Match m: playedMatches){
            if(m.getMatchName().equals("Home Team vs Chelsea") && m.getHtStrat().equals("Offensive")
               && m.getOtStrat().equals("Offensive") && m.getOutcome().equals("Win")){
               counter++;
            }
         }
         return counter;
   }
   
   //A method returning the number of Offensive-Offensive line-up match wins of the home team when facing Manchester City.
   public static int offensiveStratWinsVsManchesterCity(ArrayList<Match> playedMatches){
      int counter = 0;
         for(Match m: playedMatches){
            if(m.getMatchName().equals("Home Team vs Manchester City") && m.getHtStrat().equals("Offensive")
               && m.getOtStrat().equals("Offensive") && m.getOutcome().equals("Win")){
               counter++;
            }
         }
         return counter;
   }
}
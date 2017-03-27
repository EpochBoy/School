//Class made by Jonas Tvede Henriksen.
public class Match{

//Creating String variables.
//ht short for Home Team, ot short for Opposing Team.
private String matchname;
private String htstrat;
private String otstrat;
private String outcome;

   //Constructor for Match objects, which also sets the values of the String variables.
   public Match(String matchname, String htstrat, String otstrat, String outcome){
      this.matchname = matchname;
      this.htstrat = htstrat;
      this.otstrat = otstrat;
      this.outcome = outcome;
   }
   
   //Get methods for the String variables.
   public String getMatchName(){
      return matchname;
   }
   
   public String getHtStrat(){
      return htstrat;
   }
   
   public String getOtStrat(){
      return otstrat;
   }
   
   public String getOutcome(){
      return outcome;
   }
}
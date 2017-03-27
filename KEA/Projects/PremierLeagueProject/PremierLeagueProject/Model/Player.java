//Class made by Daniel Refn
package Model;

public class Player{

private int salary;
private int goals;
private int wins;
private int losses;
private int draws;
// 0 = keeper, 1 = defender, 2 = midfielder, 3 = attacker.
private int position;
// player has a number which is unique for each player
private String name;
private int matches = wins + losses + draws;


   public Player(String name, int wins, int losses, int draws, int salary, int position, int goals){
      this.name = name;
      this.wins = wins;
      this.losses = losses;
      this.draws = draws;
      this.salary = salary;
      this.position = position;
      this.goals = goals;
   }

   public void setSalary(int salary){
      this.salary = salary;
   }
   public int getSalary(){
      return salary;
   }
   public void setGoals(int goals){
      this.goals = goals;
   }
   public int getGoals(){
      return goals;
   }
   public void setLosses(int losses){
      this.losses = losses;
   }
   public int getLosses(){
      return losses;
   }
   public void setWins(int wins){
      this.wins = wins;
   }
   public int getWins(){
      return wins;
   }
   public void setDraws(int draws){
      this.draws = draws;
   }
   public int getDraws(){
      return draws;
   }
   public void setPosition(int position){
      this.position = position;
   }
   public int getPosition(){
      return position;
   }
   public void setName(String name){
      this.name = name;
   }
   public String getName(){
      return name;
   }
   public void setMatches(){
      this.matches = matches;
   }
   public int getMatches(){
      return losses + wins + draws;
   }
   public String toString(){
      return (name);
   }
}
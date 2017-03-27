import java.util.ArrayList;

public class ThingUtilRC{
   
   public static void main(String[] args){
      
      //Creating a new ArrayList called BoxOfThings.
      ArrayList<Thing> BoxOfThings = new ArrayList<Thing>();
      
      //Creating a reference to the Util class called u.
      Util u = new Util();
      
      //Creating 10 new Thing-objects.
      Thing th1 = new Thing("Remote control");
      Thing th2 = new Thing("Phone");
      Thing th3 = new Thing("Kitchen knife");
      Thing th4 = new Thing("Tea cup");
      Thing th5 = new Thing("Java coffee mug");
      Thing th6 = new Thing("Club");
      Thing th7 = new Thing("Magazine");
      Thing th8 = new Thing("Java coffee mug");
      Thing th9 = new Thing("Gas mask");
      Thing th10 = new Thing("Secret weapon");
      
      //Adding the Thing-objects to the ArrayList, BoxOfThings.
      BoxOfThings.add(th1);
      BoxOfThings.add(th2);
      BoxOfThings.add(th3);
      BoxOfThings.add(th4);
      BoxOfThings.add(th5);
      BoxOfThings.add(th6);
      BoxOfThings.add(th7);
      BoxOfThings.add(th8);
      BoxOfThings.add(th9);
      BoxOfThings.add(th10);
      
      //Calling and eventually printing the result of calling the methods from the Util class, using the newly created ArrayList and Thing-objects. 
      System.out.println("Let us put all the java coffee mugs in this other crate: " + u.getByType(BoxOfThings, "Java coffee mug"));
      System.out.println("Does the box of things contain a club?: " + u.certainThing(BoxOfThings, "Club"));
      System.out.println("Does the box of things contain a shovel?: " + u.certainThing(BoxOfThings, "Shovel"));
   }
}
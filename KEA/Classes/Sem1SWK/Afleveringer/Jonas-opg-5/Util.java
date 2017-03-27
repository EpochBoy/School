import java.util.ArrayList;

public class Util{

public boolean hasCertainThing;
   //A method which returns an ArrayList with thing-objects from another ArrayList if they are equal to the String type in the mthod scope.
   public ArrayList<Thing> getByType(ArrayList<Thing> things, String type){
      ArrayList<Thing> hasEqualThings = new ArrayList<Thing>();
      for(Thing t: things){
         if((t.toString()).equals(type)){
            hasEqualThings.add(t);
         }
      }
      return hasEqualThings;
   }
   //A method which returns a boolean that will evolve to either true or false, depending on whether or not the object is equal to the String type2 in the method scope.
   public boolean certainThing(ArrayList<Thing> things2, String type2){
      for(Thing t2: things2){
         if(t2.toString().equalsIgnoreCase(type2)){
            hasCertainThing = true;
         }
         else{
            hasCertainThing = false;
         }
      }
      return hasCertainThing;
   }
}
public class RunClient{

   //Dette er en én linjes kommentar
   /* Dette er flere linjers kommentar
     main metoden er der hvor dit program starter fra
   */

   /* Exercise 1 / Answers
      1. Object Tree / hasLeaves
      2. Object Computer / canCompute
      3. Object Car / willDrive
   */

   public static void main(String[] args){

      //type variabelnavn = "new" konstruktørens navn(parametre)

      //here we create an object
      Bike b = new Bike();

      /*this creates a null-pointer exception.
      because b is null and we try to call a method on it
      you can try to uncomment the comment to see it bee thrown
      */
      //b = null;
      //b1.setGear(21);

      //her kalder vi ride() metoden på Bike b
      b.ride();
      b.setGear(9);
      b.setColor("Red");
      b.setWheels(2);
      System.out.println("The bike has "+b.getGear()+" gears");
      System.out.println("This bike is "+b.getColor()+" color");
      System.out.println("This bike has "+b.getWheels()+" wheels");
   }
}
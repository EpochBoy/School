public class PullingStringsRC{
   
   public static void main(String[] args){
      
      //Creating a reference to the PullingStrings class called ps.
      PullingStrings ps = new PullingStrings();
      
      //Trying out the various methods from the PullingStrings-class (Methods explained in the comments found in the PullingStrings-class).
      
      System.out.println(ps.bobSaysHi("Bob"));
      
      System.out.println(ps.firstHalfOf("WooHoo"));
      
      System.out.println(ps.firstTwoCharsOf("java"));
      
      System.out.println(ps.stringRotator("Great!"));
      
      System.out.println(ps.isBobHere("abcbob"));
      System.out.println(ps.isBobHere("b9b"));
      System.out.println(ps.isBobHere("bac"));
      
      System.out.println(ps.aroundTheStars("ab*cd"));
      System.out.println(ps.aroundTheStars("ab**cd"));
      System.out.println(ps.aroundTheStars("sm*eilly"));
   }
}
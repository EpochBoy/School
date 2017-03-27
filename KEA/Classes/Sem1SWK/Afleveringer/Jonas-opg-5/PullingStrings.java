public class PullingStrings{
   
   //Method which returns "Hello (whatever string you put in the scope) !".
   public static String bobSaysHi(String s){
      return "Hello " + s + "!";
   }
   
   //A mthod which returns half of the string from the scope.
   public static String firstHalfOf(String s){
      int length = s.length();
      int half = length/2;
      return s.substring(0, half);
   }
   
   //A method which return the first two characters of a string put in the scope.
   public static String firstTwoCharsOf(String s){
      return s.substring(0, 2);
   }
   
   //A method which reverses whatever string put in the scope.
   public static String stringRotator(String s){
      s = new StringBuffer().reverse().toString();
      return s;
   }
   
   //A method which checks whether a String contains the following line of chars: b, (Any char), b. The method returns true if this is found within the String put in the scope.
   public static boolean isBobHere(String s){
      int counter = 0;
      for (char c: s.toCharArray()){
         if(c == 'b' && counter == 0){
            counter++;
         }
         else if(counter == 1){
            counter ++;
         }
         else if(c == 'b' && counter == 2){
            return true;
         }
         else{
            counter = 0;
         }
      }
      return false;
   }
   
   //A method which removes any '*' chars along with the chars on their left and right side, found in any string put in the scope.
   public static String aroundTheStars(String s){  
      int counter = 0;
      for(char c: s.toCharArray()){
         if(c == '*'){
            return s.substring(0, counter - 1) + s.substring(counter + 2);
         }
         counter++;
      }
      return s;
   }         
}
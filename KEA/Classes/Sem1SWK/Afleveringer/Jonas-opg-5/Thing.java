//Thing-class with a constructor which enables setting the type value and an override of the toString method.
public class Thing{

private String type;
   
   public Thing(String type){
      this.type = type;
   }
   
   public String toString(){
      return type;
   }
}
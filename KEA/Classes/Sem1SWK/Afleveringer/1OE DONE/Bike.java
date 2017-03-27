public class Bike{

   private String color; //default = null
   public int gear; //default = 0
   private int wheels; //default = 0

   //public/private er access modifiers
   public Bike(String color){
      this.color = color;
   }

   //constructor
   public Bike(int gear, String color, int wheels){
      this.gear = gear;
      this.color = color;
      this.wheels = wheels;
   }

   //empty constructor
   public Bike(){}

   //This is how you write a method:
   //access modifier retur type navn parameter
   public void ride(){
      System.out.println("I'm riding yeah");
      System.out.println("I'm still riding");
   }

   public void setGear(int gear){
      this.gear = gear;
   }

   public int getGear(){
      return gear;
   }

   //Setter for color
   public void setColor(String color){
      this.color = color;
   }

   //Getter for color
   public String getColor(){
      return color;
   }

   //Setter for wheels
   public void setWheels(int wheels){
      this.wheels = wheels;
   }

   //Getter for wheels
   public int getWheels(){
      return wheels;
   }
}
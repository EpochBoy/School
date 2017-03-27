//javac *.java
//java RunClientUser
import java.util.Scanner;

public class UserInput{


	private Scanner scanner;
	private String name;

	public UserInput(){
		scanner = new Scanner(System.in);
}



	public void receiveInput(){

		System.out.println("Whats your name?");
		name = scanner.next();

		switch(name){
			case "Ben":
			System.out.println("cool name!");
			break;

			case "John":
			System.out.println("Like springer...?");
			break;

			default:
			System.out.println("I dont know you");
			break;
		}


	}

}
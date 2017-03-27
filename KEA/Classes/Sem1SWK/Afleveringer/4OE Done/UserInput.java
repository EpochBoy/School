import java.util.Scanner;


public class UserInput{

	private Scanner scanner;

	public UserInput(){
		scanner = new Scanner(System.in);
	}


	//Here we use scanner to take arguments
	public Product createProduct(){
		System.out.println("Product name: \n");
		String name = scanner.nextLine();

		System.out.println("Product ID: \n");
		int productId = scanner.nextInt();

		Product p = new Product(name, productId);

		return p;
	}

	//Here we use command line args // java RunClient Name 007
	public Product userCreateProduct(String[] args){
		Product p = null;

		if(args.length>1){
		String name = args[0];
		int productId = Integer.parseInt(args[1]);
		p = new Product(name, productId);
		}

		return p;

	}


}
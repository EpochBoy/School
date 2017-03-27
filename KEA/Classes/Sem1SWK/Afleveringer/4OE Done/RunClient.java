public class RunClient{


public static void main(String[] args) {

	UserInput ui = new UserInput();

	Product productCL =  ui.userCreateProduct(args);
	System.out.println("This is product name: "
		+productCL.getName()+
		" and this is product id "
		+productCL.getProductId());

	Product product = ui.createProduct();
	System.out.println("This is product name: "
		+product.getName()+
		" and this is product id "
		+product.getProductId());
}


}
public class RunClient{

	public static void main(String[] args) {

		Phone[] phones = new Phone[5];

		IPhone iPhone1 = new IPhone();
		IPhone iPhone2 = new IPhone();
		IPhone iPhone3 = new IPhone();
		Android android1 = new Android();
		Android android2 = new Android();

		phones[0] = iPhone1;
		phones[1] = iPhone2;
		phones[2] = iPhone3;
		phones[3] = android1;
		phones[4] = android2;

		Controller cont = new Controller();
		Phone[] iPhones = cont.getIPhones(phones);
		System.out.println(iPhones.length);
	}
}
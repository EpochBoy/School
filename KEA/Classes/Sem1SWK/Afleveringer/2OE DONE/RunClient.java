public class RunClient{

	public static void main(String[] args) {
		SkyScraper empire = new SkyScraper();
		SummerHouse liseleje = new SummerHouse();
		House villakulla = new House(1);

		//addRoom kaldes pa Summerhouse da liseleje er objekt af typen Summerhouse der nedarver House
		liseleje.addRoom();
		System.out.println("liseleje rooms: "+liseleje.getRooms());
		System.out.println(liseleje);
		//Spoerg Jon vedr. interfaces.
		System.out.println("This is what i am: "+liseleje.build(""));
		System.out.println("SummerHouse is instance of House: "+(liseleje instanceof House));

		System.out.println("");

		//Samme som ved liseleje
		empire.addFloors(5);
		System.out.println("Empire building floors: "+empire.getFloors());
		System.out.println(empire);
		//Spoerg Jon, vedr. interfaces med String.
		System.out.println(empire.build(""));
		System.out.println("SkyScraper is instance of House: "+(empire instanceof House));

		//House test
		System.out.println("");
		System.out.println("House is instance of House: "+(villakulla instanceof House));

		//Extendable test
		System.out.println("SummerHouse instance of Extendable? / "+(liseleje instanceof Extendable));
		System.out.println("SkyScraper instance of Extendable? / "+(empire instanceof Extendable));
		System.out.println("House instance of of Extendable? / "+(villakulla instanceof Extendable));

/*Jeg gaar ud fra interface instantieres paa samme facon som en super
klasse og derfor faar du samme svar som naar ser instanceof paa super klassen
Jeg er dog ikke helt sikker paa den praecise aarsag.*/

	}
}
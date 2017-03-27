public class SkyScraper extends House implements Extendable{

	private int floors;


	public SkyScraper(){
		super(0);
	}

	public void setFloors(int floors){
		this.floors = floors;
	}

	public int getFloors(){
		return floors;
	}

	public int addFloors(int floors){
		return this.floors += floors;
	}

	@Override
	public String toString(){
		return "My SkyScraper has this amount of rooms: "+getRooms();
	}

	public String build(String s){
		return "Welcome to SkyScraper";
	}
}
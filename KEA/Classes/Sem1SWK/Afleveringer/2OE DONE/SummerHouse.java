public class SummerHouse extends House implements Extendable{

	//private String whatBuilding;

	public SummerHouse(){
		super(0);
	}

	public int addRoom(int rooms){

		System.out.println("Please collect proper form from local authorities");
		return rooms;
	}

	//public void setWhatBuilding(String s){
	//	this.whatBuilding = whatBuilding;
	//}

	//public String getWhatBuilding(){
	//	return whatBuilding;
	//}

	@Override
	public String toString(){
		return "My summerhouse has rooms: "+getRooms();
	}

	//implementerer build fra interface
	public String build(String s){
		return getClass().getName();

	}
}
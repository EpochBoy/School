public class House{

	private int rooms;

	public House(int rooms){
		this.rooms = rooms;
	}

	public void setRooms(int rooms){
		this.rooms = rooms;
	}

	public int getRooms(){
		return rooms;
	}

	public int addRoom(){
		return this.rooms += 1;
	}

}
public class Bikeren{

	private int gears;
	private String color;

	//konstruktoer
	public Bikeren(int gears, String color){
		this.gears = gears;
		this.color = color;
	}

	public void setGears(int gears){
		this.gears = gears;
	}

	public int getGears(){
		return gears;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;				
	}


	public String ride(){
		return "fast rider";
	}
}
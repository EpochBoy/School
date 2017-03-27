import java.lang.StringBuffer;



public class Opgave5{

	public static void main(String[] args) {
		Opgave5 a = new Opgave5();

		a.helloBob();

		System.out.println("I was likeWoohoo now im: "+a.doWoo("Woohoo"));
		System.out.println("Used to be Java and now I'm just like: "+a.twoFirstChar("Java"));
		System.out.println("I used to be Great! now I'm: "+(a.reverseCowGirl("Great!")));
		System.out.println("That's a bit bob bob/soso, don't you think? "+a.whereTheFuckIsBob("wekjnbwwemfweinfweBoBbedededeebobbobobb"));
		System.out.println("Are you my star? "+a.getStarred("Don't be sm*eilly"));

	}

	//difficulty 1

	public void helloBob(){
		String name = "Bob";
		System.out.println("Hello "+name+"!");
	}

	public String doWoo(String str){
		return str.substring(0, str.length() / 2);
	}

	public String twoFirstChar(String str){
		return str.toLowerCase().substring(0,2);
	}

	public StringBuffer reverseCowGirl(String str){
		StringBuffer buff = new StringBuffer(str);
		return buff.reverse();
	}

	//difficulty 2


	//Husk og spoerg efter toLowerCase() saadan saa der kompenseres for stort smaat b
	public boolean whereTheFuckIsBob(String str){

		String chekkkkkBob = new String(str);

		for(int i = 0; i < chekkkkkBob.length(); i++){

			char forBob = chekkkkkBob.charAt(i);

			if(forBob == 'b'){
				if(chekkkkkBob.charAt(i+2) == 'b'){
				return true;
				}
			}
		}
		return false;
	}

	public static String getStarred(String notostar){
		int counter = 0;
		for(char a: notostar.toCharArray()){
			if(a == '*'){
				return notostar.substring(0, counter - 1) + notostar.substring(counter + 2);
			}
			counter++;
		}
		return notostar;
	}





}
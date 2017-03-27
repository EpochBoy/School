/*
Lav en klasse med en main metode

Lav en statisk metode A der throws Exception med formen:

if(x){
	...
}else{
	throw...
}

throw en Exception i A

Kald A fra main metoden
*/




public class Exceptions{


	public static void main(String[] args) {

		try{
			equalsTo(2,2);
		}
		catch(Exception e){
			System.out.println(e);
		}

	}


	private static void equalsTo(int intCompare, int intCampari)
		throws Exception{
		 if(intCompare == intCampari){
		 	System.out.println("They are equals");
		 }else{
		 	throw new Exception("They arn't equals");
		}

	}





}
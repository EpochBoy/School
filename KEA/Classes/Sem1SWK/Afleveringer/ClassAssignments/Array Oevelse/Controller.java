public class Controller{

//ting vi skal bruge
	//instanceof
	//loop

	public IPhone[] getIPhones(Phone[] phones){

		//finde antal iphones i array
		int count = 0;


		for(int i = 0; i < phones.length; i++){
			if(phones[i] instanceof IPhone){
				count++;
			}
		}

		//oprette nyt array med plads til dem
		IPhone[] iPhones = new IPhone[count];



		//flytter hverr enkelt iphone obj. fra phones til nyt array
		int index = 0;
		for(int i = 0; i < phones.length; i++){
			if(phones[i] instanceof IPhone){
				//
				iPhones[index] = (IPhone)phones[i];
				index++;
			}
		}
		return iPhones;
		// returnerer det nye array
	}
}
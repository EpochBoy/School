public class DiodeLight implements SimpleObserver {


    public DiodeLight(SimpleObservable obj){
        obj.registerObserver(this);
    }

    @Override
    public void update(SimpleObservable obj) {
        ElectronicDevice state = (ElectronicDevice)obj;
        if (state.getState().equalsIgnoreCase("on")) {
            System.out.println("The diode is now green.");
        }  if (state.getState().equalsIgnoreCase("hibernate")) {
            System.out.println("The diode is now red.");
        }  if (state.getState().equalsIgnoreCase("off")) {
            System.out.println("The diode is turned off.");
        }
    }
}

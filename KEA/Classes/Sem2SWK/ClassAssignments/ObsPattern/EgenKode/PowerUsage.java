public class PowerUsage implements SimpleObserver {


    public PowerUsage(SimpleObservable obj){
        obj.registerObserver(this);
    }


    @Override
    public void update(SimpleObservable obj) {
        ElectronicDevice state = (ElectronicDevice)obj;
        if (state.getState().equalsIgnoreCase("on")) {
            System.out.println("The power usage is normal.");
        } if (state.getState().equalsIgnoreCase("hibernate")) {
            System.out.println("Power save mode.");
        } if (state.getState().equalsIgnoreCase("off")) {
            System.out.println("No power usage.");
        }
    }
}

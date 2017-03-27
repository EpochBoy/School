import java.util.ArrayList;

public class ElectronicDevice implements SimpleObservable{

    private String state; //on, off, hibernate

    private ArrayList<SimpleObserver> observers = new ArrayList();

    @Override
    public void registerObserver(SimpleObserver obj) {
        if(obj == null) throw new NullPointerException("Cannot add Observer with null value");
        if(!observers.contains(obj))
            observers.add(obj);
    }

    @Override
    public void removeObserver(SimpleObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (int i=0; i< observers.size(); i++ )
            observers.get(i).update(this);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        System.out.println("The state is: "+state);
        this.state = state;

        notifyObservers();
    }

}

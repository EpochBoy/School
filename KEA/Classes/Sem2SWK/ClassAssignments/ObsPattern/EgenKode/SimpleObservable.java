public interface SimpleObservable {

    //methods to register and unregister observers
    void registerObserver(SimpleObserver obj);
    void removeObserver(SimpleObserver obj);

    //method to notify observers of change
    void notifyObservers();
}

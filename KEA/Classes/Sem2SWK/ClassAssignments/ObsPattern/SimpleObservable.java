/**
 * Created by signeborch on 14/02/16.
 */
public interface SimpleObservable
{
    //methods to register and unregister observers
    public void registerObserver(SimpleObserver obj);
    public void removeObserver(SimpleObserver obj);

    //method to notify observers of change
    public void notifyObservers();
}
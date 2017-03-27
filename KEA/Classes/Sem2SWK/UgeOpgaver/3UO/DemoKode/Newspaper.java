import java.util.ArrayList;

/**
 * Created by signeborch on 14/02/16.
 */
public class Newspaper implements SimpleObservable
{
    private ArrayList<SimpleObserver> observers = new ArrayList();
    private String news;


    @Override
    public void registerObserver(SimpleObserver obj)
    {
        if(obj == null) throw new NullPointerException("Cannot add Observer with null value");
        if(!observers.contains(obj))
            observers.add(obj);
    }

    @Override
    public void removeObserver(SimpleObserver obj)
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {

        for (int i=0; i< observers.size(); i++ )
            observers.get(i).update(this);
    }

    public String getNews()
    {
        return news;
    }

    public void setNews(String news){
        System.out.println("The news of today in the newspaper office is:  "+ news);
        this.news=news;

        notifyObservers();
    }
}
/**
 * Created by signeborch on 14/02/16.
 */
public class Subscriber implements SimpleObserver
{
    private String name;
    public Subscriber(SimpleObservable obj, String name)
    {
        this.name = name;
        obj.registerObserver(this);
    }

    @Override
    public void update(SimpleObservable obj)
    {
        //Newspaper n = (Newspaper) obj; This does the same as ((Newspaper) obj)) in next line.
        System.out.println( name +" is happy to read in the paper that the news of today is " + ((Newspaper) obj).getNews());
    }
}
/**
 * Created by signeborch on 14/02/16.
 */


public class FreeNewspaperStealingNews implements SimpleObserver
{
    String name;
    public FreeNewspaperStealingNews(SimpleObservable obj, String name)
    {
        this.name = name;
        obj.registerObserver(this);
    }

    @Override
    public void update(SimpleObservable obj)
    {
        System.out.println("The journalists at " + name + " have come across great news: " + ((Newspaper)obj).getNews() );
    }
}

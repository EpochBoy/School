/**
 * Created by signeborch on 14/02/16.
 */
public class NewspaperTest
{
    public static void main(String[] args)
    {

        Newspaper politiken = new Newspaper();

        Subscriber signe = new Subscriber(politiken, "Signe");
        Subscriber asger = new Subscriber(politiken, "Asger");
        Subscriber david = new Subscriber(politiken, "David");
        Subscriber arne = new Subscriber(politiken, "Arne");
        FreeNewspaperStealingNews metroxpress = new FreeNewspaperStealingNews(politiken, "MetroXpress");

        politiken.setNews("**Storm på vej mod Danmark**");


        Newspaper Anarchistnews = new Newspaper();
        Subscriber HDV = new Subscriber(Anarchistnews, "Ham Den Vilde");
        FreeNewspaperStealingNews kommunisten = new FreeNewspaperStealingNews(Anarchistnews, "Kommunisten");
        Anarchistnews.setNews("Regeringen er vaeltet.");

    }
}
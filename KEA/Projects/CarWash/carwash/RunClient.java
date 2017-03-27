public class RunClient
{
   public static void main (String[] args)
   {
      AccountManager AM = new AccountManager();
      Reader R = new Reader();
      R.initReader(AM);
   }
}      
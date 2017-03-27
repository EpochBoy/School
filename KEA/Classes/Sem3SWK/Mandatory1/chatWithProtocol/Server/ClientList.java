package chatWithProtocol.Server;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by forneus on 02/11/2016.
 */
public class ClientList {
    private static ClientList ourInstance = new ClientList();

    public static ClientList getInstance() {
        return ourInstance;
    }

    private ArrayList<String> userNameArray;

    private Lock lock = new ReentrantLock();

    private ClientList() {
        this.userNameArray = new ArrayList<>();
    }

    public Boolean addToList(String userName){
        try{
            this.lock.tryLock();
            for (int i = 0; i < this.userNameArray.size(); i++){
                if (this.userNameArray.get(i).equals(userName))
                return false;
            }
            this.userNameArray.add(userName);
            return true;
        }finally {
            this.lock.unlock();
        }
    }

    public void removeFromList(String userName){
        try {
            this.lock.tryLock();
            for (int i = 0; i < this.userNameArray.size(); i++){
                if (this.userNameArray.get(i).equals(userName)){
                    this.userNameArray.remove(i);
                    return;
                }
            }
        }finally {
            this.lock.unlock();
        }
    }

    public ArrayList<String> getUserNameArray(){
        return this.userNameArray;
    }

}

package chat2;

import oracle.jvm.hotspot.jfr.StackTrace;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by forneus on 03/10/2016.
 */
public class Server extends Thread {

    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;

    private int maxClientsCount = 10;
    private Client[] threads = new Client[maxClientsCount];

    public static Server instance = new Server(); // eager
    //public static Server instance; // lazy


    public static Server getInstance() {
        return instance;
    }

    private Server(){
    }

    public void startServer() {

        int port = 5555;
        System.out.println("Server port: " + port);
        if (serverSocket == null) {
            while (true) {
                try {
                    System.out.println(serverSocket);
                    serverSocket = new ServerSocket(port);
                    clientSocket = serverSocket.accept();
                    System.out.println("SERVER: Client Connected");
                    int i;
                    for (i = 0; i < maxClientsCount; i++) {
                        if (threads[i] == null) {
                            (threads[i] = new Client(clientSocket, threads)).start();
                            break;
                        }
                    }
                    System.out.println("jeg er under forlykke");
                    if (i == maxClientsCount) {
                        clientSocket.close();
                        serverSocket.close();
                    }
                } catch (IOException ioe) {
                    System.out.println("Seems server is already running on this port");
                    ioe.printStackTrace();
                    break;
                }
            }
        } else {
            while (true) {
                try {
                    clientSocket = serverSocket.accept();
                    int i;
                    for (i = 0; i < maxClientsCount; i++) {
                        if (threads[i] == null) {
                            (threads[i] = new Client(clientSocket, threads)).start();
                            break;
                        }
                    }
                    if (i == maxClientsCount) {
                        clientSocket.close();
                    }
                } catch (IOException ioe) {
                    System.out.println("Exception in start server 2" + ioe);
                    break;
                }
            }
        }
    }


    public void stopServer() {
        try {
            serverSocket.close();
            int i;
            for (i = 0; i< maxClientsCount; i++){
                // TODO: 13/10/2016 Server has to send shutdown message to all clients.
            }
        } catch (Exception e) {
            System.out.println("Exception in stop server" + e);
        }

    }


}




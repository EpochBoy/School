package chatWithProtocol.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by forneus
 */
public class Server {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    public static final Client[] threads = new Client[1000];


    public static void main(String[] args) {
        int port = 5555;
        if (args.length < 1){
            System.out.println("Opened a server on port: "+port);
        }else{
            port = Integer.valueOf(args[0]).intValue();
        }

        try {
            serverSocket = new ServerSocket(port);
        }catch (IOException ioe){
            System.out.println("Caught an exception trying to create Server Socket");
            ioe.printStackTrace();
        }

        while (true){
            try {
                clientSocket = serverSocket.accept();
                int i;
                for (i = 0; i < threads.length; i++){
                    if (threads[i] == null){
                        (threads[i] = new Client(clientSocket, threads)).start();
                        break;
                    }
                }
                if (1000 < threads.length){
                    PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
                    printStream.println("Sorry, chat is full");
                    printStream.close();
                    clientSocket.close();
                }
            }catch (IOException ioe){
                System.out.println("Failed to create a Client Socket");
                ioe.printStackTrace();
            }
        }
    }


}

package chatWithProtocol.Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by forneus
 */
public class Client extends Thread {

    private String username = null;
    private Socket clientSocket = null;
    private final Client[] threads;
    private int maxClients;
    private DataInputStream inputStream = null;
    private PrintStream printStream = null;

    private String clientName = null;

    public Client(Socket clientSocket, Client[] threads) {
        this.clientSocket = clientSocket;
        this.threads = threads;
        maxClients = threads.length;
    }

    public void run() {
        int maxClients = this.maxClients;
        Client[] threads = this.threads;

        try {
            inputStream = new DataInputStream(clientSocket.getInputStream());
            printStream = new PrintStream(clientSocket.getOutputStream());
//
            String inputTester;
            while ((inputTester = inputStream.readLine()) != null) {
                System.out.println(inputTester);
                if (inputTester.startsWith("JOIN")) {
                    Pattern pattern = Pattern.compile("JOIN\\s([a-zA-Z0-9-_]+),.*");
                    //Pattern pattern = Pattern.compile("ˆJOIN(\\w{1,12}?),(.{1,255}?):(\\d{1,5}?)");
                    Matcher matcher = pattern.matcher(inputTester);
                    matcher.find();
//                    while (matcher.find()){
//                        System.out.print(matcher.group(1));
//                    }
                    clientName = matcher.group(1).substring(0, matcher.group(1).length() >= 12 ? 11 : matcher.group(1).length());
//                    if (matcher.group(1).length() >= 12)
//                        return 11;
//                    else
//                        return matcher.group(1).length()
                    if (!ClientList.getInstance().addToList(clientName)) {
                        printStream.println("J_ERR");
                        clientName = null;
                    } else {
                        break;
                    }
                }
            }


//            while (true) {
////                if (inputStream.toString().startsWith("JOIN")){
////                    clientName = inputStream.toString().substring(5, 17);
////                }
//                printStream.println("Enter your name");
//                clientName = inputStream.readLine().trim();
//                if (clientName.length() > 12) {
//                    printStream.println("Your username cannot exceed 12 characters.");
//                }
//                else if(!clientName.matches("^[a-zA-Z0-9-_]+$")){
//                    printStream.println("Unsupported format");
//                }
//                else {
//                    break;
//                }
//            }

            printStream.println("J_OK");
            printStream.println(clientName + " Welcome to the channel! Type !Commands to see your options");

            synchronized (this) {
                for (int i = 0; i < maxClients; i++) {
                    if (threads[i] != null && threads[i] == this) {
                        username = clientName;
                        break;
                    }
                }

                for (int i = 0; i < maxClients; i++) {
                    if (threads[i] != null && threads[i] == this) {
                        threads[i].printStream.println(clientName + " has joined the channel");
                    }
                }
            }
            String line;
            while ((line = inputStream.readLine()) != null) {
                Pattern pattern = Pattern.compile("^DATA\\s(.+):\\s(.*)\\s?");
                Pattern pattern1 = Pattern.compile(".*:\\s(.*)");
                //Pattern pattern = Pattern.compile("ˆJOIN(\\w{1,12}?),(.{1,255}?):(\\d{1,5}?)");
                Matcher matcher = pattern.matcher(line);
                Matcher matcher1 = pattern1.matcher(line);
                matcher.find();
                matcher1.find();
                //String command = matcher.group() != null ? matcher.group(1) : "";
                String username = matcher.groupCount() > 0 ? matcher.group(1) : "";
                String command = matcher.groupCount() > 1 ? matcher.group(2) : "";
                String message = matcher1.groupCount() > 0 ? matcher1.group(1) : "";
                switch (command) {
                    case "QUIT":
                        return;
                    case "LIST":
                        synchronized (this) {
                            printStream.println(String.join("\n", ClientList.getInstance().getUserNameArray()));
                        }
                        break;
                    case "ALVE":
                        System.out.println(clientName + " is Alive");
                        break;
                    default:
                        if (message.length() > 250) {
                            printStream.println("Message too long");
                            break;
                        }
                    synchronized (this) {
                        for (int i = 0; i < maxClients; i++) {
                            if (threads[i] != null && threads[i].username != null) {
                                threads[i].printStream.println(username + " says > " + message);
                            }
                        }
                    }
                    break;
                }
            }

            synchronized (this) {
                for (int i = 0; i < maxClients; i++) {
                    if (threads[i] != null && threads[i] != this && threads[i].username != null) {
                        threads[i].printStream.println(clientName + " has left the chat");
                    }
                }
            }

            synchronized (this) {
                for (int i = 0; i < maxClients; i++) {
                    if (threads[i] == this) {
                        ClientList.getInstance().removeFromList(username);
                        threads[i] = null;
                    }
                }
            }

            inputStream.close();
            printStream.close();
            clientSocket.close();


        } catch (IOException ioe) {
            System.out.println("IOE 2");
            ioe.printStackTrace();
        }

    }
}





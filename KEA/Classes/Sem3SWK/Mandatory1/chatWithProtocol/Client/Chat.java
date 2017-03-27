package chatWithProtocol.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Chat implements Runnable {

    private static Socket clientSocket = null;
    private static PrintStream printStream = null;
    private static DataInputStream inputStream = null;
    private static BufferedReader bufferedReader = null;

    private static String userName;
    private static InetAddress ip;
    private static int port;

    private static boolean isClosed = false;
    private static boolean imAlive = true;


    public static void main(String[] args) throws UnknownHostException {

        ip = InetAddress.getLocalHost();
        port = 5555;
        userName = "Forneus";

        //getUserInfo();

        try {
            clientSocket = new Socket(ip, port);
            printStream = new PrintStream(clientSocket.getOutputStream());
            inputStream = new DataInputStream(clientSocket.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException ioe) {
            System.out.println("ioe 3");
            ioe.printStackTrace();
        }
        printStream.println("JOIN " + userName + "," + ip + ":" + port);
        if (clientSocket != null && printStream != null && inputStream != null) {
            try {
                new Thread(new Chat()).start();
                while (!isClosed) {
                    new Thread(() -> {
                        while (imAlive) {
                            printStream.println(composeMessage(userName, "ALVE"));
                            try {
                                Thread.sleep(60000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    printStream.println(composeMessage(userName, bufferedReader.readLine()));
                }

                printStream.close();
                inputStream.close();
                clientSocket.close();
            } catch (IOException ioe) {
                System.out.println("IOE 1");
                ioe.printStackTrace();
            }
        }
    }

    public void run() {
        String serverReply;
        try {
            while ((serverReply = inputStream.readLine()) != null || (serverReply.startsWith("J_OK"))) {
                System.out.println(serverReply);
                if (serverReply.startsWith("J_ERR")) {
                    System.out.println("Username already taken!");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please Input new Username");
                    userName = scanner.next();
                    scanner.close();



                }
            }
            isClosed = true;
            //System.out.println("Now closing chat");
            //System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Error in Server Reply");
            ioe.printStackTrace();
        }
    }

    public static String composeMessage(String userName, String message) {
        return "DATA " + userName + ": " + message;
    }

    public static void getUserInfo() throws UnknownHostException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        userName = scanner.next();
        System.out.println("Please enter Server Ip you want to connect to");
        ip = InetAddress.getByName(scanner.next());
        System.out.println("Please enter port number");
        port = scanner.nextInt();
        System.out.println(userName + ", you are now connecting using IP: " + ip + " and port: " + port);
        scanner.close();

    }


}
package chat2;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by forneus on 03/10/2016.
 */
public class Client extends Thread {

    private int port;
    private String username;
    private InetAddress ip;

    public Socket getClientSocket() {
        return clientSocket;
    }

    private Socket clientSocket = null;
    private Client[] threads;
    private int maxClientsCount;
    private boolean amIConnected = false;

    private ServerInputView serverInputView;
    private Chat chat;
    private Server server;
    private SceneInitializer sceneInitializer;
    private String message;
    private String myMessage;

    public Client(ServerInputView serverInputView, Chat chat, Server server, SceneInitializer sceneInitializer){
        this.serverInputView = serverInputView;
        this.chat = chat;
        this.server = server;
        this.sceneInitializer = sceneInitializer;
    }

    public Client(){}

    public Client(Socket clientSocket, Client[] threads){
        this.clientSocket = clientSocket;
        this.threads = threads;
        this.maxClientsCount = threads.length;
    }


    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "This Client: " +
                " Username = " + username +
                " / IP = " + ip +
                " / Port = " + port +
                "/ Client Position " +"Insert later";
    }

    public String clientMessage(String message){
        this.myMessage = message;
        System.out.println("From Client: " + message);
        return message;
    }


    public void startClient(){
    try {
        //clientSocket = new Socket(String.valueOf(Integer.parseInt(serverInputView.getIpAddress())), Integer.parseInt(serverInputView.getPortNumber()));
        clientSocket = new Socket(ip, port);
        amIConnected = true;
    }catch (Exception e){
        System.out.println("Couldn't connect to server");
    }do {
// TODO: 13/10/2016 do something here
    }while (amIConnected == true);
    }

}




//    public void clientMessage() throws Exception{
//        String message;
//        String modMessage;
//        BufferedReader fromClient = new BufferedReader(new InputStreamReader(System.in));
//        clientSocket =  new Socket("localhost", Integer.parseInt(serverInputView.getPortNumber()));
//        DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
//        BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        message = fromClient.readLine();
//        toServer.writeBytes(message + "\n");
//        modMessage = fromServer.readLine();
//        System.out.println("From Server:" + modMessage);
//        clientSocket.close();

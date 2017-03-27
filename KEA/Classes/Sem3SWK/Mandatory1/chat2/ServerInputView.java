package chat2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import static chat2.Client.*;

/**
 * Created by forneus on 29/09/2016.
 */
public class ServerInputView extends Pane {

    private BorderPane serverInputPane;
    private VBox serverInputVbox;
    private TextField ipTextField;
    private TextField portTextField;
    private Button cancelButton;
    private Button confirmButton;
    public SceneInitializer sceneInitializer;
    public Client myClient;
    public UserNameView userNameView;


    private String ipAddress;
    private String portNumber;

    public ServerInputView(SceneInitializer sceneInitializer, Client myClient, UserNameView userNameView) throws IOException {

        this.userNameView = userNameView;
        this.sceneInitializer = sceneInitializer;
        this.myClient = myClient;

        serverInputPane = new BorderPane();
        serverInputVbox = new VBox(50);
        ipTextField = new TextField();
        portTextField = new TextField();
        cancelButton = new Button("Cancel");
        confirmButton = new Button("Confirm");

        serverInputPane.setPrefSize(499,499);
        serverInputPane.setStyle("-fx-border-color: black;");

        ipTextField.setPromptText("IP:xxx.xxx.xxx.xxx");
        ipTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
        ipTextField.setMaxSize(200,50);
        ipTextField.setOnKeyPressed(this::getIpAndPortAddressKey);
        ipTextField.setOnMouseClicked(this::getIpAndPortAddressMouse);


        portTextField.setPromptText("Port: XXXXX");
        portTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
        portTextField.setMaxSize(200,50);
        portTextField.setOnKeyPressed(this::getIpAndPortAddressKey);

        cancelButton.setPrefSize(100,50);
        cancelButton.setOnMouseClicked(event -> sceneInitializer.changeScene("cancelServerInput"));

        confirmButton.setPrefSize(100,50);
        confirmButton.setOnMouseClicked(event -> sceneInitializer.changeScene("chatProgram"));

        serverInputVbox.setAlignment(Pos.CENTER);

        serverInputVbox.getChildren().addAll(
                ipTextField,
                portTextField,
                confirmButton,
                cancelButton
        );

        serverInputPane.setCenter(serverInputVbox);

        this.getChildren().addAll(
                serverInputPane
        );


    }


    private void getIpAndPortAddressKey(KeyEvent ke) {
        if (ke.getCode() == KeyCode.ENTER) {
            this.ipAddress = ipTextField.getText();
            if (ipAddress.equals(null)) {
                System.out.println("Please input IP");
            } else {
                Scanner readIp = new Scanner(ipAddress);
                readIp.useDelimiter("\\.");
                for (int i = 0; i < 4; i++) {
                    if (readIp.hasNext()) {
                        try {
                            int isInt = Integer.parseInt(readIp.next());
                            if (isInt > 255 || isInt < 0) {
                                System.out.println("IP numbers are between 0>255");
                                ipTextField.clear();
                                ipTextField.setPromptText("Incorrect Format");
                            }
                        } catch (NumberFormatException exceeded) {
                            System.out.println("Please use a correct format");
                        }
                    }
                }
                if (readIp.hasNext()) {
                    System.out.println("Your ip, should use xxx.xxx.xxx.xxx format!");
                }
                if (ipAddress.charAt(ipAddress.length() - 1) == '.') {
                    System.out.println("Don't put a . infront of an IP!");
                }
            }
        this.portNumber = portTextField.getText();
        System.out.println("My IP Address is: " + ipAddress);
        System.out.println("My Port number is: " + portNumber);
        this.sceneInitializer.changeScene("chatProgram");
//            try {
//                myClient = new Client(userNameView.getUsername(), InetAddress.getByName(ipAddress),
//                        Integer.parseInt(portNumber));
//                System.out.println(myClient);
//                myClient.startClient();
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
            try {
                this.myClient = new Client();
                myClient.setUsername(userNameView.getUsername());
                myClient.setIp(InetAddress.getByName(ipAddress));
                myClient.setPort(Integer.parseInt(portNumber));
                System.out.println(myClient);
                myClient.startClient();
            }catch (UnknownHostException uhe){
                System.out.println(uhe);
            }
        }
    }




    private void getIpAndPortAddressMouse(MouseEvent me) {
        if (me.getButton() == MouseButton.PRIMARY) {
            this.ipAddress = ipTextField.getText();
            Scanner readIp = new Scanner(ipAddress);
            readIp.useDelimiter("\\.");
            for (int i = 0; i < 4; i++) {
                if (readIp.hasNext()) {
                    try {
                        int isInt = Integer.parseInt(readIp.next());
                        if (isInt > 255 || isInt < 0) {
                            System.out.println("IP numbers are between 0>255");
                            ipTextField.clear();
                            ipTextField.setPromptText("Incorrect Format");
                        }
                    } catch (NumberFormatException exceeded) {
                        System.out.println("Please use a correct format");
                    }
                }
            }
            if (readIp.hasNext()){
                System.out.println("Your ip, should use xxx.xxx.xxx.xxx format!");
            }
            if (ipAddress.charAt(ipAddress.length()-1) == '.'){
                System.out.println("Don't put a . in front of an IP!");
            }
            System.out.println("My IP Address is: " + ipAddress);
            this.portNumber = portTextField.getText();
            System.out.println("My Port number is: " + portNumber);
            this.sceneInitializer.changeScene("chatProgram");
        }
    }



    public String getIpAddress() {
        return ipAddress;
    }

    public String getPortNumber() {
        return portNumber;
    }
}

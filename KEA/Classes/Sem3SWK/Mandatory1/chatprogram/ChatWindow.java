package chatprogram;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.Scanner;

public class ChatWindow extends Pane implements Resizable {

private Button connectButton;
private TextArea inputArea;
private TextArea outputArea;
private TextField ipTextField;
private TextField usernameField;

private String ipAddress;
private String username;
//private StringBuffer ipChecker;

public ChatWindow() {
    inputArea = new TextArea();
    outputArea = new TextArea();
    connectButton = new Button("Connect");
    ipTextField = new TextField();
    usernameField = new TextField();

    ipTextField.setPromptText("IP:xxx.xxx.xxx.xxx");
    ipTextField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
    //ipChecker = new StringBuffer(int+""+int""+ );

    usernameField.setPromptText("Input Username");

    inputArea.setWrapText(true);

    outputArea.setEditable(false);
    outputArea.setWrapText(true);

    this.getChildren().addAll(
            inputArea,
            outputArea,
            connectButton,
            ipTextField,
            usernameField
    );

    inputArea.setOnKeyPressed(this::updateChatWindow);

    ipTextField.setOnKeyPressed(this::getIpAddressKey);

    usernameField.setOnKeyPressed(this::getUsername);


}


private void updateChatWindow(KeyEvent ke){

    if (ke.getCode() == KeyCode.ENTER) {
        outputArea.setText(outputArea.getText() + username +": " +inputArea.getText()+"\n");
        inputArea.clear();
    }
}

private void getIpAddressKey(KeyEvent ke){
    if (ke.getCode() == KeyCode.ENTER) {
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
            System.out.println("Don't put a . infront of an IP!");
        }
    }
}

private void getUsername(KeyEvent ke){
    if (ke.getCode() == KeyCode.ENTER){
        this.username = usernameField.getText();
    }
}

    @Override
public void updateLayout() {

    outputArea.setLayoutX(10);
    outputArea.setLayoutY(10);
    outputArea.setPrefSize(980, 800);

    inputArea.setLayoutX(10);
    inputArea.setLayoutY(825);
    inputArea.setPrefSize(800, 150);

    connectButton.setLayoutX(845);
    connectButton.setLayoutY(925);
    connectButton.setPrefSize(120, 50);

    ipTextField.setLayoutX(825);
    ipTextField.setLayoutY(825);
    ipTextField.setPrefSize(150, 25);

    usernameField.setLayoutX(825);
    usernameField.setLayoutY(870);
    usernameField.setPrefSize(150, 25);
    }
}
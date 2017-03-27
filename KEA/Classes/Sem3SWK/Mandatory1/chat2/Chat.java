package chat2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by forneus on 29/09/2016.
 */
public class Chat extends Pane{

    private BorderPane chatPane;
    private VBox chatVBox;
    private HBox chatHBox;
    private Button disconnectButton;

    public TextField getInputArea() {
        return inputArea;
    }

    private TextField inputArea;
    private TextArea outputArea;
    private UserNameView userNameView;
    private Client client;

    public Chat(SceneInitializer sceneInitializer, UserNameView userNameView, Client client) {

        this.userNameView = userNameView;
        this.client = client;

        chatPane = new BorderPane();
        chatVBox = new VBox();
        chatHBox = new HBox();
        disconnectButton = new Button("Disconnect");
        inputArea = new TextField();
        outputArea = new TextArea();

        chatPane.setPrefSize(499,499);
        chatPane.setStyle("-fx-border-color: black;");

//      inputArea.setWrapText(true);
        inputArea.setPrefSize(498,40);
        inputArea.setOnKeyPressed(this::updateChatWindow);


        outputArea.setPrefSize(498,459);
        outputArea.setEditable(false);
        outputArea.setWrapText(true);

        chatVBox.setAlignment(Pos.CENTER);
        chatHBox.setAlignment(Pos.BOTTOM_RIGHT);


        disconnectButton.setOnMouseClicked(event -> sceneInitializer.changeScene("disconnectFromChat"));


        chatVBox.getChildren().addAll(
                outputArea,
                inputArea
        );

        chatHBox.getChildren().addAll(
                disconnectButton
        );

        chatPane.setCenter(chatVBox);
        chatPane.setBottom(chatHBox);

        this.getChildren().addAll(
                chatPane
        );
    }

    public void updateChatWindow(KeyEvent ke){
        if (ke.getCode() == KeyCode.ENTER) {
            outputArea.setText(outputArea.getText() + userNameView.getUsername() +": " +inputArea.getText()+"\n");
            client.clientMessage(inputArea.getText());
            inputArea.clear();
        }
    }
}

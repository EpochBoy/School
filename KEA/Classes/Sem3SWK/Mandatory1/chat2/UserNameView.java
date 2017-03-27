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

/**
 * Created by forneus on 20/09/16.
 */
public class UserNameView extends Pane{

    private VBox userBox;
    private Button confirmUserName;
    private Button cancelSelection;
    private TextField userName;
    private BorderPane userSetView;
    private SceneInitializer sceneInitializer;


    public String getUsername() {
        return username;
    }

    private String username;


    public UserNameView(SceneInitializer sceneInitializer) {


        userSetView = new BorderPane();
        this.sceneInitializer = sceneInitializer;

        userBox = new VBox(50);
        confirmUserName = new Button("Confirm");
        cancelSelection = new Button("Cancel");
        userName = new TextField();
        confirmUserName.setPrefSize(100,50);
        cancelSelection.setPrefSize(100,50);

        cancelSelection.setOnMouseClicked(event -> this.sceneInitializer.changeScene("cancelUserNameInput"));
        confirmUserName.setOnMouseClicked(this::confirmUserNameMouse);
        userName.setOnKeyPressed(this::confirmUserNameKey);
//        confirmUserName.setOnMouseClicked(event -> this.sceneInitializer.changeScene("goToServerInput"));

        userName.setMaxSize(200,50);
        userName.setPromptText("Input Username");
        userName.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");


        userSetView.setPrefSize(499,499);
        userSetView.setStyle("-fx-border-color: black;");

        userBox.setAlignment(Pos.CENTER);

        userBox.getChildren().addAll(
                userName,
                confirmUserName,
                cancelSelection
        );

        userSetView.setCenter(userBox);

        this.getChildren().addAll(
                userSetView
        );


    }

    public String confirmUserNameMouse(MouseEvent me) {

        if (me.getButton() == MouseButton.PRIMARY){
            username = userName.getText();
            this.sceneInitializer.changeScene("goToServerInput");
        }
        System.out.println("My Username is: "+username);
        return username;
    }

    public String confirmUserNameKey(KeyEvent ke){
        if (ke.getCode() == KeyCode.ENTER) {
            username = userName.getText();
            System.out.println("My Username is: " + username);
            this.sceneInitializer.changeScene("goToServerInput");
        }
        return username;
    }
}

package chat2;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by forneus on 20/09/16.
 */
public class SceneInitializer {


    public Stage theStage;
    public Scene mainLogin;
    public Scene setUserView;
    public Scene serverInputView;
    public Scene chatView;

    public void initialize(Stage window) throws IOException {

        theStage = window;
        window.show();
        window.setTitle("I work");

        LoginView loginView = new LoginView(this);
        UserNameView userNameView = new UserNameView(this);
        Client client = new Client();
        ServerInputView serverInputViewer = new ServerInputView(this, client, userNameView);
        Chat createChat = new Chat(this,userNameView, client);
        //Server myServer = new Server();

        mainLogin = new Scene(loginView,500,500);
        setUserView = new Scene(userNameView,500,500);
        serverInputView = new Scene(serverInputViewer, 500,500);
        chatView = new Scene(createChat, 500,500);
        window.setScene(mainLogin);
        window.setResizable(false);
    }


    public void changeScene(String sceneChange){
        if (sceneChange.equals("goToUsernameInput")){
            theStage.setScene(setUserView);
            theStage.setTitle("Welcome to Chat 9000");
        }
        if (sceneChange.equals("cancelUserNameInput")){
            theStage.setScene(mainLogin);
            theStage.setTitle("Welcome to Chat !9000");
        }
        if (sceneChange.equals("goToServerInput")){
            theStage.setScene(serverInputView);
            theStage.setTitle("Server Information");
        }
        if (sceneChange.equals("cancelServerInput")){
            theStage.setScene(setUserView);
            theStage.setTitle("Cancelled Server Input");
        }
        if (sceneChange.equals("chatProgram")){
            theStage.setScene(chatView);
            theStage.setTitle("Get Chatting! You chatter you!");
        }
        if (sceneChange.equals("disconnectFromChat")){
            theStage.setScene(mainLogin);
            theStage.setTitle("Welcome back to Main Sceen");
        }

    }


}
